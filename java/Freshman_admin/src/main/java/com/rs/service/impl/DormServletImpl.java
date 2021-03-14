package com.rs.service.impl;

import com.rs.dao.DormDao;
import com.rs.entity.Dorm;
import com.rs.service.DormServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DormServletImpl implements DormServlet {
    @Resource
    private DormDao dormDao;
    @Override
    public List<Dorm> queryAllDorm() {
        List<Dorm> dorms = dormDao.queryAllDorm();
        return dorms;
    }

    @Override
    public List<Dorm> queryDormByClassesId(String classesId) {
        List<Dorm> dorms = dormDao.queryDormByClassesId(classesId);
        return dorms;
    }

    @Override
    public Dorm queryDormByDormId(String dormId) {
        Dorm dorm = dormDao.queryDormByDormId(dormId);
        return dorm;
    }

    @Override
    public void addPeople(String dormId) {
        dormDao.addPeople(dormId);
    }
}
