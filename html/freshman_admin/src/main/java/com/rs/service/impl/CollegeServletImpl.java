package com.rs.service.impl;

import com.rs.dao.CollegeDao;
import com.rs.entity.College;
import com.rs.service.CollegeServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CollegeServletImpl implements CollegeServlet {
    @Resource
    private CollegeDao schoolDao;

    @Override
    public List<College> queryAllCollege() {
        List<College> schools = schoolDao.queryAllCollege();
        return schools;
    }
}
