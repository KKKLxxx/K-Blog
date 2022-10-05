package com.kkkl.kblogserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkkl.kblogserver.dao.bean.Article;
import com.kkkl.kblogserver.service.ArticleService;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/getAll")
    public HashMap<String, Object> getAll(int curPage, int pageSize, @RequestParam(defaultValue = "0") int categoryId) {
        Page<Article> pages = articleService.getAll(curPage, pageSize, categoryId);
        return ResultFormat.formatResult(pages);
    }

    @GetMapping("/getDetail")
    public HashMap<String, Object> getDetail(int articleId) {
        Article article = articleService.getDetail(articleId);
        return ResultFormat.formatResult(article);
    }
}
