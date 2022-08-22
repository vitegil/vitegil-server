package com.vitegil.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.vitegil.pojo.Error;
import com.vitegil.service.ErrorService;
import com.vitegil.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/error")
public class ErrorController {

    @Autowired
    private ErrorService errorService;

    /**
     * 接受前端发过来的总的error信息,已完成
     */
    @RequestMapping(value = "/saveErrorTotal", method = RequestMethod.POST)
    public Result saveError(@RequestBody String errorInfo) {
//        System.out.println("saveError..........");
        //errorInfo是json字符串
//        System.out.println(errorInfo);
//        JSONObject jsonObject = JSONObject.parseObject(errorInfo);
//        Error error = jsonObject.to(Error.class);
//        errorService.saveError(error);
//        System.out.println("saveError.................");
//        System.out.println(errorInfo);
//        for (Error error : errorList) {
//            errorService.saveError(error);
//        }

        JSONArray objects = JSONArray.parseArray(errorInfo);
        for (Object object : objects) {
            Error error = JSONObject.parseObject(object.toString(), Error.class);
//            if (error.getErrorType().equals("click-event")){
//                return null;
//            }
            errorService.saveError(error);
        }

        return Result.ok("error注入成功...");
    }

    /**
     * 接受单个请求
     * @param error
     * @return
     */
    @RequestMapping(value = "/saveError", method = RequestMethod.POST)
    public Result saveError(@RequestBody Error error) {
        errorService.saveError(error);
        return Result.ok("error注入成功...");
    }

    @RequestMapping("/getError")
    public Result getError(@RequestParam String appId) {
        Map<String,Object> jsMap = new HashMap<>();
        jsMap.put("grade",errorService.getJSGrade(appId));
        jsMap.put("data",errorService.getErrorByTime(appId,"js-error"));

        Map<String,Object> promiseMap = new HashMap<>();
        promiseMap.put("grade",errorService.getPromiseGrade(appId));
        promiseMap.put("data",errorService.getErrorByTime(appId,"promise-error"));

        Map<String,Object> resourceMap = new HashMap<>();
        resourceMap.put("grade",errorService.getResourceGrade(appId));
        resourceMap.put("data",errorService.getErrorByTime(appId,"resource-error"));

        Map<String,Object> res = new HashMap<>();
        res.put("allGrade", errorService.getTotalGrade(appId));
        res.put("jsError",jsMap);
        res.put("promiseError",promiseMap);
        res.put("resourceError",resourceMap);

        return Result.ok(res);
    }
}
