package com.kkkl.kblogserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkkl.kblogserver.dao.bean.Article;
import com.kkkl.kblogserver.service.ArticleService;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有文章
     */
    @GetMapping("/getAll")
    public HashMap<String, Object> getAll(int curPage, int pageSize, @RequestParam(defaultValue = "0") int categoryId) {
        Page<Article> pages = articleService.getAll(curPage, pageSize, categoryId);
        return ResultFormat.formatResult(pages);
    }

    /**
     * 根据id获取文章
     */
    @GetMapping("/getById")
    public HashMap<String, Object> getById(int articleId) {
        Article article = articleService.getById(articleId);
        return ResultFormat.formatResult(article);
    }

    /**
     * 直接将本地文章写入数据库
     * @param path 本地路径
     * @param categoryId 文章分类
     */
    @PostMapping("/postLocalArticle")
    public HashMap<String, Object> postLocalArticle(String path, int categoryId) {
        articleService.postLocalArticle(path, categoryId);
        return ResultFormat.formatResult("写入成功");
    }

    /**
     * 将整个学习笔记文件夹上传
     * @param path 整个文件夹的路径
     */
    @PostMapping("/postWholeLocalDirectory")
    public HashMap<String, Object> postWholeLocalDirectory(String path) {
        articleService.postWholeLocalDirectory(path);
        return ResultFormat.formatResult("写入成功");
    }
}
