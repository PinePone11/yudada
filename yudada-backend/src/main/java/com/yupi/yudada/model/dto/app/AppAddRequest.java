package com.yupi.yudada.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建应用请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
@Data
    //xxRequest对应前端增删改查接口， AppAddRequest只写必写参数
    //app实体类存在数据库中，方便扩展给每一个接口写一个请求类接收前端参数
public class AppAddRequest implements Serializable {

    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用描述
     */
    private String appDesc;

    /**
     * 应用图标
     */
    private String appIcon;

    /**
     * 应用类型（0-得分类，1-测评类）
     */
    private Integer appType;

    /**
     * 评分策略（0-自定义，1-AI）
     */
    private Integer scoringStrategy;

    private static final long serialVersionUID = 1L;
}
