package com.vitegil.service;

import com.vitegil.pojo.App;

import java.util.List;

public interface AppService {

    //查
    public List<App> findAll();
    public App findAppById(String id);

    //增
    public void save(App app);
    //删
    public void deleteById(String id);
    //改
    public void update(App app);
}
