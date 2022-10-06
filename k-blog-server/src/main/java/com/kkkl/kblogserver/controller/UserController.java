package com.kkkl.kblogserver.controller;

import com.kkkl.kblogserver.dao.bean.User;
import com.kkkl.kblogserver.dao.mapper.UserMapper;
import com.kkkl.kblogserver.service.UserService;
import com.kkkl.kblogserver.util.RandomValueUtil;
import com.kkkl.kblogserver.util.RedisKeyFormat;
import com.kkkl.kblogserver.util.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @GetMapping("/sendRegisterEmail")
    public HashMap<String, Object> sendRegisterEmail(String email) {
        String key = RedisKeyFormat.formatRegisterKey(email);
        String randomValue = RandomValueUtil.get4Int();
        redisTemplate.opsForValue().set(key, randomValue, 5, TimeUnit.MINUTES);
        userService.sendRegisterEmail(email, randomValue);
        return ResultFormat.formatResult("验证码发送成功，有效时间5分钟");
    }
}
