package com.kkkl.kblogserver.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkkl.kblogserver.dao.bean.Article;
import com.kkkl.kblogserver.dao.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
