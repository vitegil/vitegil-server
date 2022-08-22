package com.vitegil.service;

import com.vitegil.pojo.PV;

public interface PVService {

    public void savePV(PV pv);

    public Long getPVNumsByAppId(String appId);

    public int[] getPVByTime(String appId);
}
