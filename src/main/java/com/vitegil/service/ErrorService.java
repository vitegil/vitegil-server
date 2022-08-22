package com.vitegil.service;

import com.vitegil.pojo.Error;

public interface ErrorService {

    public void saveError(Error error);

    public int[] getErrorByTime(String appId, String errorType);

    public Integer getJSGrade(String appId);
    public Integer getPromiseGrade(String appId);
    public Integer getResourceGrade(String appId);

    public Integer getTotalGrade(String appId);

    public Long getTotalError(String appId);
}
