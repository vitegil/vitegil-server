package com.vitegil.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vitegil.mapper.DeviceMapper;
import com.vitegil.pojo.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

//    @Override
//    public List<Device> findDeviceByUserId(Integer userId) {
//        QueryWrapper<Device> qw = new QueryWrapper<>();
//        qw.eq("user_id", userId);
//        return deviceMapper.selectList(qw);
//    }

    @Override
    public void saveDevice(Device device) {
        deviceMapper.insert(device);
    }

    @Override
    public Long getUV(String appId) {
        QueryWrapper<Device> qw = new QueryWrapper<>();
        qw.select("DISTINCT user_id")
                .eq("app_id", appId);
        Long count = deviceMapper.selectCount(qw);
//        System.out.println("count = " + count);
        return count;
    }

    @Override
    public int[] getUVByTime(String appId) {
        //wrapper.select("count(xxx) xxx,date_format('%Y-%m-%d %h) xxx'");
        //        wrapper.between("时间字段","开始","结束");
        //        wrapper.groupBy("date_format(时间字段,'%Y-%m-%d %h)");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        System.out.println("format = " + format);

        //构建一个查询的wrapper
        QueryWrapper<Device> qw = new QueryWrapper<>();
        //统计个数
        qw.select("count(DISTINCT user_id), date_format(time,'%Y-%m-%d %H')")
                //区间
//                .between("time","","")
                //指纹不能一样
//                .select("DISTINCT user_id")
                //根据appId查
                .eq("app_id", appId)
                //大于等于今天
                .ge("time",format)
                //根据小时分类
                .groupBy("date_format(time,'%Y-%m-%d %H')");

        List<Map<String, Object>> maps = deviceMapper.selectMaps(qw);
//        maps.forEach(System.out::println);
        int[] timeArr = new int[24];//下标 0-23
        for (Map<String, Object> map : maps) {
            Long num = (Long) map.get("count(DISTINCT user_id)");
            String timeStr = (String) map.get("date_format(time,'%Y-%m-%d %H')");
            String s = timeStr.split(" ")[1];
//            System.out.println("s = " + s);
            int index = Integer.parseInt(s);
//            System.out.println("index = " + index);
            timeArr[index] = num.intValue();
        }

        //{count(1)=4, date_format(time,'%Y-%m-%d %H')=2022-08-19 13}
        //{count(1)=2, date_format(time,'%Y-%m-%d %H')=2022-08-19 03}
        //{count(1)=2, date_format(time,'%Y-%m-%d %H')=2022-08-19 10}
        //{count(1)=1, date_format(time,'%Y-%m-%d %H')=2022-08-19 17}

        return timeArr;
    }
}
