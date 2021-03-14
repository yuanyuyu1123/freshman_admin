package com.rs.service;

import com.rs.entity.College;

import java.util.List;

public interface CollegeServlet {
    /**查询学校信息*/
    public List<College> queryAllCollege();
}
