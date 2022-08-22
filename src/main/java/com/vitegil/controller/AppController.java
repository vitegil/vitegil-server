package com.vitegil.controller;

import com.alibaba.fastjson2.JSONObject;
import com.vitegil.pojo.App;
import com.vitegil.service.AppService;
import com.vitegil.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app")
public class AppController {

    @Autowired
    private AppService appService;

    /**
     * 查询所有app
     * @return
     */
    @RequestMapping("/getApp")
    public Result findAll() {
        List<App> apps = appService.findAll();
        return Result.ok(apps);
    }

    /**
     * 接受前端发过来的请求体 RequestBody
     */
    @RequestMapping(value = "/addApp", method = RequestMethod.POST)
    public Result saveApp(@RequestBody String appInfo) {
//        System.out.println("save方法.......");
//        System.out.println("app = " + app);
        //app = App(id=null, adminName=ss, appId=ssid, appName=ss_name, appDesc=null)
        //说明当JSON串和参数对应的时候，直接注入了
        //若携带缺省值,也可以，缺省值为null
        //若 请求体Body中的JSON串的key和POJO属性不一样，注入的是null！
        JSONObject jsonObject = JSONObject.parseObject(appInfo);
        JSONObject data = jsonObject.getJSONObject("data");
        String appId = data.getString("appId");
        String appName = data.getString("appName");
        App app = new App();
        app.setAppId(appId);
        app.setAppName(appName);
        appService.save(app);
        List<App> all = appService.findAll();
        return Result.ok(all);
    }
}

