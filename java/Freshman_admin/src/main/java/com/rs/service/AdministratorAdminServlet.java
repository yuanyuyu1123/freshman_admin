package com.rs.service;

import com.rs.entity.AdministratorAdmin;

public interface AdministratorAdminServlet {
    /**根据adminId查找管理员密码*/
    AdministratorAdmin queryAdministratorAdmin(String adminId);

    /**更新学管理员密码*/
    void updateAdministrator(AdministratorAdmin administratorAdmin);

    /**保存管理员密码*/
    void saveAdministratorAdmin(AdministratorAdmin administratorAdmin);

    /**删除管理员管理信息*/
    void deleteAdministratorPasswordById(String stuId);
}
