package com.vitegil.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;

/**
 * 监控错误的信息
 */

@Data
@NoArgsConstructor
@TableName("error")
public class Error {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String appId;//监控的应用id，即web地址，如：www.baidu.com
    private String url;//页面URL
    @JsonProperty("event")
    private String errorType;//错误类型
    private String errorInfo;//错误的详细信息
    private String errorUrl;//要访问的路径
    private Integer errorRow;//错误行
    private Integer errorCol;//错误列
    private String errorExtra;//额外信息
    private String userId;//用uuid精准定位每个用户，指纹信息
    private Timestamp time;//时间戳
}
