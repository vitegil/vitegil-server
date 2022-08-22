package com.vitegil.service;

import com.vitegil.pojo.Device;

import java.util.List;

public interface DeviceService {

    /**
     * 查询所有的device
     */
//    public List<Device> findAllDevice();

    /**
     * 通过 user_id 查询
     */
//    public List<Device> findDeviceByUserId(Integer userId);

    public void saveDevice(Device device);

    /**
     * getUV数量 访客数
     */
    public Long getUV(String appId);

    /**
     * 根据时间段UV数量 访客数
     */
    public int[] getUVByTime(String appId);
}
