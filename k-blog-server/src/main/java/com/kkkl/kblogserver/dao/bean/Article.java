package com.kkkl.kblogserver.dao.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("t_article")
public class Article {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 标题
    private String title;

    // 内容
    private String content;

    // 简介
    private String intro;

    // 分类id
    private Integer categoryId;

    // 是否推荐，0不推荐，1推荐
    private Integer recommend;

    // 点赞数
    private String likeNum;

    // 阅读数
    private String readNum;

    // 创建时间
    @OrderBy
    private String createTime;

    // 分类名称
    @TableField(exist = false)
    private String categoryName;

    // 分类封面
    @TableField(exist = false)
    private String categoryCover;
}
