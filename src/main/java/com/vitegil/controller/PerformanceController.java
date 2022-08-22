package com.vitegil.controller;


import com.vitegil.pojo.Performance;
import com.vitegil.service.PerformanceService;
import com.vitegil.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;


    /**
     * 接受前端发过来的performance信息,已完成
     */
    @RequestMapping(value = "/savePerformance", method = RequestMethod.POST)
    public Result savePerformance(@RequestBody Performance performance) {
//        JSONObject object = jsonObject.getJSONObject("data");
//        Performance performance = object.to(Performance.class);
        performanceService.savePerformance(performance);
        return Result.ok("performance注入成功!");
    }

    /**
     * 携带query参数 参数名：appId
     * @param appId
     * @return
     */
    @RequestMapping("/getPerformance")
    public Result getPerformance(@RequestParam String appId) {
        Performance p = performanceService.getAvgPerformanceByAppId(appId);
        System.out.println("p = " + p);
        return Result.ok(p);
    }
}
