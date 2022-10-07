package com.kkkl.kblogserver.dao.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@TableName("t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 父评论id
    private Integer pid;

    // 评论内容
    private String content;

    // 所评论文章的文章id
    private Integer articleId;

    // 评论人id
    private Integer userId;

    // 评论人用户名
    private String username;

    @OrderBy
    private String createTime;

    // 该评论的回复
    @TableField(exist = false)
    private List<Comment> replyList = new ArrayList<>();

    public void addReply(Comment reply) {
        replyList.add(reply);
    }
}
