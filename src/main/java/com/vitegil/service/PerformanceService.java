package com.vitegil.service;

import com.vitegil.pojo.Performance;

public interface PerformanceService {

    public void savePerformance(Performance performance);

    /**
     * 根据appId查询Performance的 "平均" 性能
     * @param appId 监控的网站的url
     */
    public Performance getAvgPerformanceByAppId(String appId);
}
