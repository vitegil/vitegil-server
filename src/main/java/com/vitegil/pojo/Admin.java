package com.vitegil.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 管理员
 */

@Data
@NoArgsConstructor
@TableName("admin")
public class Admin {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String adminName; //用户名
    private String adminPasswd; //密码
    private String mobile;
}
