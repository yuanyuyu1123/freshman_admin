package com.rs.dao;

import com.rs.entity.AdministratorAdmin;

public interface AdministratorAdminDao {
    /**根据adminId查找管理员*/
    AdministratorAdmin queryAdministratorAdmin(String adminId);

    /**更新学管理员密码*/
    void updateAdministratorAdmin(AdministratorAdmin administratorAdmin);

    /**保存管理员密码*/
    void saveAdministratorAdmin(AdministratorAdmin administratorAdmin);

    /**删除管理员管理信息*/
    void deleteAdministratorPasswordById(String stuId);
}
