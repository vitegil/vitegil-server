package com.vitegil.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.vitegil.pojo.Device;
import com.vitegil.pojo.Error;
import com.vitegil.service.DeviceService;
import com.vitegil.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;



@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 接受前端发过来的device信息,已完成
     */
    @RequestMapping(value = "/saveDevice", method = RequestMethod.POST)
    public Result saveDevice(@RequestBody String deviceInfo) {
        System.out.println(deviceInfo);
        JSONObject jsonObject = JSONObject.parseObject(deviceInfo);
        Device device = jsonObject.to(Device.class);
        deviceService.saveDevice(device);
        return Result.ok("device注入成功!");
    }

    /**
     * 根据user_id的不同，统计UV的总数 不用用户的访问数
     */
    @RequestMapping("/getUV")
    public Result getUV(@RequestParam String appId) {
        int[] timeArr = deviceService.getUVByTime(appId);//根据时间段获取uv数量
        int totalUV = deviceService.getUV(appId).intValue();//获取不同用户的访问总数
        HashMap<String,Object> map = new HashMap<>();
        map.put("tatalUV",totalUV);
        map.put("timeArr",timeArr);
        return Result.ok(map);
    }

    /**
     * 根据时间段的不同，统计UV的数量
     */
    @RequestMapping("/getUVByTime")
    public Result getUVByTime(String appId) {
        int[] timeArr = deviceService.getUVByTime(appId);
        return Result.ok(timeArr);
    }
}
