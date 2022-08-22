package com.vitegil.service;

import com.vitegil.mapper.AppMapper;
import com.vitegil.pojo.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appService")
public class AppServiceImpl implements AppService{

    @Autowired
    private AppMapper appMapper;

    /**
     * 查询所有的App集合
     * @return
     */
    @Override
    public List<App> findAll() {
        //通过条件构造器查询一个list集合，若没有条件，则参数可以设置null
        return appMapper.selectList(null);
    }

    @Override
    public App findAppById(String app_id) {
        return appMapper.selectById(app_id);
    }

    @Override
    public void save(App app) {
        appMapper.insert(app);
    }

    @Override
    public void deleteById(String app_id) {
        appMapper.deleteById(app_id);
    }

    @Override
    public void update(App app) {
        appMapper.update(app,null);
    }
}
