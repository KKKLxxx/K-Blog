package com.kkkl.kblogserver.controller;

import com.kkkl.kblogserver.dao.bean.Comment;
import com.kkkl.kblogserver.service.CommentService;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/getByArticleId")
    public HashMap<String, Object> getByArticleId(int articleId) {
        List<Comment> list = commentService.getByArticleId(articleId);
        return ResultFormat.formatResult(list);
    }
}
