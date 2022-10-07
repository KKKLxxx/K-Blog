package com.kkkl.kblogserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkkl.kblogserver.dao.bean.Article;
import com.kkkl.kblogserver.dao.bean.Category;
import com.kkkl.kblogserver.dao.mapper.ArticleMapper;
import com.kkkl.kblogserver.dao.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

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
        }
        return pages;
    }

    public Article getById(int articleId) {
        return articleMapper.selectById(articleId);
    }

    public void postLocalArticle(String path, int categoryId) {
        String title = "";
        String content = "";
        String createTime = "";

        try {
            File file = new File(path);
            title = file.getName();
            title = title.substring(0, title.length() - 3); // 删除.md三个字符

            byte[] bytes = Files.readAllBytes(Paths.get(path));
            // 删除第一行的标题
            int start = 0;
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] == 13) {
                    start = i + 4;
                    break;
                }
            }
            bytes = Arrays.copyOfRange(bytes, start, bytes.length);
            content = new String(bytes);

            long lastModified = file.lastModified();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            createTime = dateFormat.format(lastModified);
        } catch (IOException ignored) {

        }

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateTime(createTime);
        article.setCategoryId(categoryId);
        articleMapper.insert(article);
    }

    public void postWholeLocalDirectory(String path) {
        File parentDirectory = new File(path);
        File[] directoryList = parentDirectory.listFiles(); // 获取所有子文件夹

        // 获取分类 <名称, id> 的对应关系
        List<Category> categories = categoryService.getAll();
        HashMap<String, Integer> map = new HashMap<>();
        for (Category category : categories) {
            map.put(category.getName(), category.getId());
        }

        for (File directory : directoryList) {
            if (directory.isFile()) {
                continue; // 跳过README.md
            }
            if (!map.containsKey(directory.getName())) {
                continue; // 跳过隐藏文件夹
            }

            File[] files = directory.listFiles();
            int categoryId = map.get(directory.getName());
            Category category = categoryMapper.selectById(categoryId);
            category.setTotal(files.length);
            categoryMapper.updateById(category);
            for (File file : files) {
                postLocalArticle(file.getAbsolutePath(), categoryId);
            }
        }
    }
}
