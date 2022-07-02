package com.kkkl.kblogserver.controller;

import com.kkkl.kblogserver.dao.bean.User;
import com.kkkl.kblogserver.dao.mapper.UserMapper;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/get")
    public HashMap<String, Object> getAllUser() {
        List<User> users = userMapper.selectList(null);
        return ResultFormat.formatResult(0, users);
    }
}
