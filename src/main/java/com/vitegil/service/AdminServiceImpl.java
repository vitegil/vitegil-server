package com.vitegil.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vitegil.mapper.AdminMapper;
import com.vitegil.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.selectList(null);
    }

    @Override
    public Admin findAdmin(String username, String password) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("admin_name",username);
        adminQueryWrapper.eq("admin_passwd",password);
        return adminMapper.selectOne(adminQueryWrapper);
    }
}
