package com.rs.service;

import com.rs.entity.Administrator;

import java.util.List;

public interface AdministratorServlet {
    /**查询所有管理员信息*/
    List<Administrator> queryAllAdministrator();
    /**根据admin_Id查找Administrator*/
    Administrator queryAdministratorById(String adminId);
    /**更新Administrator*/
    void updateAdministrator(Administrator administrator);
    /**保存Administrator*/
    void saveAdministrator(Administrator administrator);
    /**根据adminId删除Administrator*/
    void deleteAdministrator(String adminId);
}
