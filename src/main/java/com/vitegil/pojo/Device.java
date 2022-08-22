package com.vitegil.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;

/**
 * 设备信息
 */

@Data
@NoArgsConstructor
@TableName("device")
public class Device {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String appId;//监控的web地址，如：www.baidu.com
    private String deviceType;//设备类型
    @JsonProperty("OS")
    private String os; //操作系统
    @JsonProperty("OSVersion")
    private String osVersion; //操作系统版本
    private Integer screenHeight; //屏幕高
    private Integer screenWidth; //屏幕宽
    private String language; //当前使用的语言
    private String network; //联网类型
    private String orientation; //横竖屏
    private String browser;//浏览器类型
    private String browserInfo; //浏览器信息
    private String userId;//uuid精准定位每个用户，指纹信息
//    @JsonProperty("timeStamp")
    private Timestamp time;//时间戳

    //private String urlPath;
    //Timestamp    YYYY-MM-DD HH:MM:SS.[fff...]    1970-01-01 00:00:00~9999-12-31 23:59:59
    //Java获取当前时间戳保存至数据库操作时，可用以下代码获取并封装传参
    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
}
