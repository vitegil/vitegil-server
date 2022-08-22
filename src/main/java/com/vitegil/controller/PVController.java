package com.vitegil.controller;


import com.alibaba.fastjson2.JSONObject;
import com.vitegil.pojo.PV;
import com.vitegil.service.PVService;
import com.vitegil.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/pv")
public class PVController {

    @Autowired
    private PVService pvService;


    /**
     * 接受前端发过来的PV信息,已完成
     */
    @RequestMapping(value = "/savePVs", method = RequestMethod.POST)
    public Result savePVs(@RequestBody List<PV> pvList) {
//        System.out.println(pvList);
        System.out.println("savePVs...");
//        System.out.println("pvList = " + pvList);
        for (PV pv : pvList) {
//            System.out.println(pv);
            pvService.savePV(pv);
        }
        return Result.ok("pvs注入成功!");
    }

    /**
     * 统计PV
     */

    @RequestMapping("/getPV")
    public Result getPV(@RequestParam String appId) {
        int[] timeArr = pvService.getPVByTime(appId);//根据时间获取PV数
        int totalPV = pvService.getPVNumsByAppId(appId).intValue();//获取总PV数
        HashMap<String,Object> map = new HashMap<>();
        map.put("tatalPV",totalPV);
        map.put("timeArr",timeArr);
        return Result.ok(map);
    }
}
