package com.vitegil.service;

import com.vitegil.pojo.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 查询所有的用户
     * @return
     */
    public List<Admin> findAllAdmin();

    /**
     * 根据用户名和密码查找某个用户是否存在
     * @param admin
     * @return
     */
    public Admin findAdmin(String username, String password);
}
