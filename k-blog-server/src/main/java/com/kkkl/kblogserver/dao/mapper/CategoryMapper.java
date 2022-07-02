package com.kkkl.kblogserver.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkkl.kblogserver.dao.bean.Article;
import com.kkkl.kblogserver.dao.bean.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
