package com.vitegil.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vitegil.mapper.ErrorMapper;
import com.vitegil.pojo.Error;
import com.vitegil.pojo.PV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("errorService")
public class ErrorServiceImpl implements ErrorService{

    @Autowired
    private ErrorMapper errorMapper;

    @Override
    public void saveError(Error error) {
        errorMapper.insert(error);
    }

    @Override
    public int[] getErrorByTime(String appId, String errorType) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);

        //构建一个查询的wrapper
        QueryWrapper<Error> qw = new QueryWrapper<>();
        //统计个数
        qw.select("count(1), date_format(time,'%Y-%m-%d %H')")
                //大于等于今天
                .eq("app_id",appId)
                .eq("error_type", errorType)
                .ge("time",format)
                //根据小时分类
                .groupBy("date_format(time,'%Y-%m-%d %H')");

        List<Map<String, Object>> maps = errorMapper.selectMaps(qw);
//        maps.forEach(System.out::println);
        int[] timeArr = new int[24];//下标 0-23
        for (Map<String, Object> map : maps) { //根据取到的值更新时间数组
            Long num = (Long) map.get("count(1)");
            String timeStr = (String) map.get("date_format(time,'%Y-%m-%d %H')");
            String s = timeStr.split(" ")[1];
            int index = Integer.parseInt(s);
            timeArr[index] = num.intValue();
        }
        return timeArr;
    }

    @Override
    public Integer getJSGrade(String appId) {
        //构建一个查询的wrapper
        QueryWrapper<Error> qw = new QueryWrapper<>();
        qw.eq("error_type", "js-error")
                .eq("app_id", appId);
        int js = errorMapper.selectCount(qw).intValue();
        System.out.println("js = " + js);
        int total = getTotalError(appId).intValue();
        System.out.println("total = " + total);
        double res = (double)js/total * 100;
        return (int) res;
    }

    @Override
    public Integer getPromiseGrade(String appId) {
        //构建一个查询的wrapper
        QueryWrapper<Error> qw = new QueryWrapper<>();
        qw.eq("error_type", "promise-error")
                .eq("app_id", appId);
        int promise = errorMapper.selectCount(qw).intValue();
        System.out.println("promise = " + promise);
        int total = getTotalError(appId).intValue();
        double res = (double)promise/total * 100;
        return (int) res;
    }

    @Override
    public Integer getResourceGrade(String appId) {
        //构建一个查询的wrapper
        QueryWrapper<Error> qw = new QueryWrapper<>();
        qw.eq("error_type", "resource-error")
                .eq("app_id", appId);
        int resource = errorMapper.selectCount(qw).intValue();
        System.out.println("resource = " + resource);
        int total = getTotalError(appId).intValue();
        double res = (double)resource/total * 100;
        return (int) res;
    }

    @Override
    public Integer getTotalGrade(String appId) {
        int total = getTotalError(appId).intValue();
        int sum = errorMapper.selectCount(new QueryWrapper<Error>().eq("app_id",appId)).intValue();
        double res = (double)total/sum * 100;
        return 100 - (int) res;
    }

    @Override
    public Long getTotalError(String appId) {
        Long res = errorMapper.selectCount(new QueryWrapper<Error>().eq("app_id",appId)) -
                errorMapper.selectCount(new QueryWrapper<Error>().eq("error_type","click-event")
                        .eq("app_id",appId));

//        System.out.println("getTotalError:" + res.intValue());
        return res;
    }
}
