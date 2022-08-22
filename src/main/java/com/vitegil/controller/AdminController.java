package com.vitegil.controller;


import com.alibaba.fastjson2.JSONObject;
import com.vitegil.pojo.Admin;
import com.vitegil.service.AdminService;
import com.vitegil.util.JWTUtils;
import com.vitegil.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 登录，目前就简单实现 用户名 vitegil 密码 vitegil
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody String adminInfo) {
        System.out.println(adminInfo);
        JSONObject jsonObject = JSONObject.parseObject(adminInfo);
        System.out.println(jsonObject);
        JSONObject data = jsonObject.getJSONObject("data");
        String username = data.getString("account");
        String password = data.getString("password");

        Admin admin = adminService.findAdmin(username, password);
        if (admin == null) {
            return Result.error("登录失败，请重新登录！");
        }
        //如果存在 使用jwt生成Token返回给前端
//        String token = JWTUtils.createToken(admin.getId());
        //整合redis 未实现...
        return Result.ok("登录成功!");
    }
}
