package com.rs.service.impl;

import com.rs.dao.AdministratorDao;
import com.rs.entity.Administrator;
import com.rs.service.AdministratorServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdministratorServletImpl implements AdministratorServlet {
    @Resource
    private AdministratorDao administratorDao;

    @Override
    public List<Administrator> queryAllAdministrator() {
        List<Administrator> administrators = administratorDao.queryAllAdministrator();
        return administrators;
    }

    @Override
    public Administrator queryAdministratorById(String adminId) {
        Administrator administrator = administratorDao.queryAdministratorById(adminId);
        return administrator;
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        administratorDao.updateAdministrator(administrator);
    }

    @Override
    public void saveAdministrator(Administrator administrator) {
        administratorDao.saveAdministrator(administrator);
    }

    @Override
    public void deleteAdministrator(String adminId) {
        administratorDao.deleteAdministrator(adminId);
    }
}
