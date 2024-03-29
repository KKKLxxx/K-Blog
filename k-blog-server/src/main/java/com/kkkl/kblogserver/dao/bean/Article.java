package com.kkkl.kblogserver.dao.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 标题
    private String title;

    // 内容
    private String content;

    // 分类id
    private Integer categoryId;

    // 创建时间
    @OrderBy
    private String createTime;

    // 分类名称
    @TableField(exist = false)
    private String categoryName;
}
