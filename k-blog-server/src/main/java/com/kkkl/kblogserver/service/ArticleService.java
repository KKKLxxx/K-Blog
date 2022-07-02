package com.kkkl.kblogserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkkl.kblogserver.dao.bean.Article;
import com.kkkl.kblogserver.dao.bean.Category;
import com.kkkl.kblogserver.dao.mapper.ArticleMapper;
import com.kkkl.kblogserver.dao.mapper.CategoryMapper;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryService categoryService;

    public Page<Article> getAll(int curPage, int pageSize, int categoryId) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        if (categoryId != 0) {
            queryWrapper.lambda().eq(Article::getCategoryId, categoryId);
        }
        Page<Article> pages = articleMapper.selectPage(new Page<>(curPage, pageSize), queryWrapper);

        List<Category> categories = categoryService.getAll();
        HashMap<Integer, Category> map = new HashMap<>();
        for (Category category : categories) {
            map.put(category.getId(), category);
        }

        for (Article article : pages.getRecords()) {
            Category category = map.get(article.getCategoryId());
            article.setCategoryName(category.getName());
            article.setCategoryCover(category.getCover());
        }
        return pages;
    }
}
