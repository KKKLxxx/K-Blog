package com.kkkl.kblogserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkkl.kblogserver.dao.bean.Comment;
import com.kkkl.kblogserver.dao.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getByArticleId(int articleId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Comment::getArticleId, articleId);
        List<Comment> comments = commentMapper.selectList(queryWrapper);

        List<Comment> firstLevelComments = comments.stream().filter(t -> t.getPid() == null).collect(Collectors.toList());
        for (Comment comment : firstLevelComments) {
            packageReply(comment, comments);
        }
        return firstLevelComments;
    }

    /**
     * 封装评论的回复
     * @param parentComment 父评论
     * @param comments 本文章的所有评论
     */
    private void packageReply(Comment parentComment, List<Comment> comments) {
        if (parentComment == null || comments.size() == 0) {
            return;
        }

        // 将所有pid与parentComment.id相同的评论，加入到parentComment的replyList中
        comments.stream().filter(t -> Objects.equals(t.getPid(), parentComment.getId())).forEachOrdered(parentComment::addReply);
        // 对parentComment的所有回复递归地进行封装操作
        for (Comment comment : parentComment.getReplyList()) {
            packageReply(comment, comments);
        }
    }
}
