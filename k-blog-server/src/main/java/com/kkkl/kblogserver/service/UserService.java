package com.kkkl.kblogserver.service;

import com.kkkl.kblogserver.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${spring.mail.username}")
    private String sender;

    @Resource
    private JavaMailSender mailSender;

    @Async("asyncServiceExecutor")
    public void sendRegisterEmail(String email, String randomValue) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(email);
        message.setSubject("注册验证码"); // 主题
        message.setText(randomValue); // 内容
        mailSender.send(message);
    }
}
