package com.kkkl.kblogserver.service;

import com.kkkl.kblogserver.dao.bean.Category;
import com.kkkl.kblogserver.dao.mapper.CategoryMapper;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAll() {
        return categoryMapper.selectList(null);
    }
}
