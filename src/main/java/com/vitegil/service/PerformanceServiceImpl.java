package com.vitegil.service;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vitegil.mapper.PerformanceMapper;
import com.vitegil.pojo.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("performanceService")
public class PerformanceServiceImpl implements PerformanceService{

    @Autowired
    private PerformanceMapper performanceMapper;

    @Override
    public void savePerformance(Performance performance) {
        performanceMapper.insert(performance);
    }

    @Override
    public Performance getAvgPerformanceByAppId(String appId) {
        QueryWrapper<Performance> qw = new QueryWrapper<>();
        qw.eq("app_id",appId);
        List<Performance> performanceList = performanceMapper.selectList(qw);
        int len = performanceList.size();
        Performance performance = new Performance();
        performance.setAppId(appId);
        Integer connectTime = 0;//TCP连接耗时
        Integer ttfbTime = 0;//发出页面请求到接收到应答数据第一个字节所花费的毫秒数
        Integer responseTime = 0;//响应时间
        Integer parseDOMTime = 0;//解析DOM时间
        Integer domContentLoadedTime = 0;//DOMContentLoaded事件时间
        Integer domContentLoaded = 0;//DOMContentLoaded时间
        Integer loadTime = 0;//完整的页面加载时间
        Integer parseDNSTime = 0;//DNS解析时间
        Integer domReadyTime = 0;//DOM准备总时间
        Integer firstPaint = 0;//页面首次渲染时间，即白屏时间
        Integer timeToInteractive = 0;// 首次可交互时间
        Integer firstContentfulPaint = 0;//首次有内容渲染
        Integer firstMeaningfulPaint = 0;//首次有意义渲染
        Integer largestContentfulPaint = 0;//最大可交互内容渲染时间
        for (Performance p : performanceList) {
            connectTime += p.getConnectTime();
            ttfbTime += p.getTtfbTime();
            responseTime += p.getResponseTime();
            parseDOMTime += p.getParseDOMTime();
            domContentLoadedTime += p.getDomContentLoadedTime();
            domContentLoaded += p.getDomContentLoaded();
            loadTime += p.getLoadTime();
            parseDNSTime += p.getParseDNSTime();
            domReadyTime += p.getDomReadyTime();
            firstPaint += p.getFirstPaint();
            timeToInteractive += p.getTimeToInteractive();
            firstContentfulPaint += p.getFirstContentfulPaint();
            firstMeaningfulPaint += p.getFirstMeaningfulPaint();
            largestContentfulPaint += p.getLargestContentfulPaint();
        }
        //取平均值
        performance.setConnectTime(connectTime/len);
        performance.setTtfbTime(ttfbTime/len);
        performance.setResponseTime(responseTime/len);
        performance.setParseDOMTime(parseDOMTime/len);
        performance.setDomContentLoadedTime(domContentLoadedTime/len);
        performance.setDomContentLoaded(domContentLoaded/len);
        performance.setLoadTime(loadTime/len);
        performance.setParseDNSTime(parseDNSTime/len);
        performance.setDomReadyTime(domReadyTime/len);
        performance.setFirstPaint(firstPaint/len);
        performance.setTimeToInteractive(timeToInteractive/len);
        performance.setFirstContentfulPaint(firstContentfulPaint/len);
        performance.setFirstMeaningfulPaint(firstMeaningfulPaint/len);
        performance.setLargestContentfulPaint(largestContentfulPaint/len);

        return performance;
    }
}
