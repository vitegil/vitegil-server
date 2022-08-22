package com.vitegil.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 表示监控的应用
 */
@Data //生成getter、setter、hashcode、tostring、无参构造
@NoArgsConstructor
@TableName("app")
public class App {

    @TableId(type = IdType.AUTO) //自增
    private Integer id;//唯一标识
    private String adminName; //写adminName可以映射admin_name

    private String appId; //app_id用来唯一标识一个web应用，如www.baidu.com
    private String appName;//起个别名
    private String appDesc;//描述信息，可以为空
}
