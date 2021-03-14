package com.rs.dao;

import com.rs.entity.College;

import java.util.List;

public interface CollegeDao {
    /**查询学校信息*/
    public List<College> queryAllCollege();
}
