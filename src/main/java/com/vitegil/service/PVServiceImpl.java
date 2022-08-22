package com.vitegil.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vitegil.mapper.PVMapper;
import com.vitegil.pojo.Device;
import com.vitegil.pojo.PV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("pvService")
public class PVServiceImpl implements PVService{

    @Autowired
    private PVMapper pvMapper;

    @Override
    public void savePV(PV pv) {
        pvMapper.insert(pv);
    }

    @Override
    public Long getPVNumsByAppId(String appId) {
        QueryWrapper<PV> qw = new QueryWrapper<>();
        qw.eq("user_id",appId);
        Long count = pvMapper.selectCount(qw);
        return count;
    }

    @Override
    public int[] getPVByTime(String appId) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);

        //构建一个查询的wrapper
        QueryWrapper<PV> qw = new QueryWrapper<>();
        //统计个数
        qw.select("count(1), date_format(time,'%Y-%m-%d %H')")
                //区间
//                .between("time","","")
                .eq("app_id",appId)
                //大于等于今天
                .ge("time",format)
                //根据小时分类
                .groupBy("date_format(time,'%Y-%m-%d %H')");

        List<Map<String, Object>> maps = pvMapper.selectMaps(qw);
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
}
