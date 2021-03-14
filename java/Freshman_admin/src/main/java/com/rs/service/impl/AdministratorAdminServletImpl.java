package com.rs.service.impl;

import com.rs.dao.AdministratorAdminDao;
import com.rs.entity.AdministratorAdmin;
import com.rs.service.AdministratorAdminServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdministratorAdminServletImpl implements AdministratorAdminServlet {
    @Resource
    private AdministratorAdminDao administratorAdminDao;
    @Override
    public AdministratorAdmin queryAdministratorAdmin(String adminId) {
        AdministratorAdmin administratorAdmin = administratorAdminDao.queryAdministratorAdmin(adminId);
        return administratorAdmin;
    }

    @Override
    public void updateAdministrator(AdministratorAdmin administratorAdmin) {
        administratorAdminDao.updateAdministratorAdmin(administratorAdmin);
    }

    @Override
    public void saveAdministratorAdmin(AdministratorAdmin administratorAdmin) {
        administratorAdminDao.saveAdministratorAdmin(administratorAdmin);
    }

    @Override
    public void deleteAdministratorPasswordById(String stuId) {
        administratorAdminDao.deleteAdministratorPasswordById(stuId);
    }
}
