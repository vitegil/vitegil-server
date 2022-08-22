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
 * 性能表现
 */
@Data
@NoArgsConstructor
@TableName("performance")
public class Performance {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String appId;//监控的应用id，即web地址，如：www.baidu.com
    private String url;//页面URL
    private Integer connectTime;// TCP连接耗时
    private Integer ttfbTime;//发出页面请求到接收到应答数据第一个字节所花费的毫秒数
    private Integer responseTime;//响应时间
    @TableField("parseDOM_time")
    private Integer parseDOMTime;//解析DOM时间
    private Integer domContentLoadedTime;//DOMContentLoaded事件时间
    private Integer domContentLoaded;//DOMContentLoaded时间
    private Integer loadTime;//完整的页面加载时间
    @TableField("parseDNS_time")
    private Integer parseDNSTime;//DNS解析时间
    private Integer domReadyTime;//DOM准备总时间
    private Integer firstPaint;//页面首次渲染时间，即白屏时间
    private Integer timeToInteractive;// 首次可交互时间
    private Integer firstContentfulPaint;//首次有内容渲染
    private Integer firstMeaningfulPaint;//首次有意义渲染
    private Integer largestContentfulPaint;//最大可交互内容渲染时间
//    @JsonProperty("uuid")
    private String userId;//用uuid精准定位每个用户，指纹信息
//    @JsonProperty("timeStamp")
    private Timestamp time;//时间戳
}
