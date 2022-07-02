package com.kkkl.kblogserver.controller;

import com.kkkl.kblogserver.dao.bean.Category;
import com.kkkl.kblogserver.dao.mapper.CategoryMapper;
import com.kkkl.kblogserver.service.CategoryService;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public HashMap<String, Object> getAll() {
        List<Category> categories = categoryService.getAll();
        return ResultFormat.formatResult(0, categories);
    }
}
