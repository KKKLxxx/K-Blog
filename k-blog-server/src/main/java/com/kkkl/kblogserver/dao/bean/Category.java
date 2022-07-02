package com.kkkl.kblogserver.dao.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_category")
public class Category {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 排序，数值越大优先级越高
     */
    @OrderBy(sort = 1)
    private Integer sort;

    /**
     * 该分类下文章总数
     * sort相同则按total从大到小排序
     */
    @OrderBy(sort = 2)
    private Integer total;

    /**
     * 分类封面
     */
    private String cover;
}
