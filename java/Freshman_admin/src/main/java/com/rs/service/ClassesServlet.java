package com.rs.service;

import com.rs.entity.Classes;

import java.util.List;

public interface ClassesServlet {
    /**查找所有班级信息*/
    public List<Classes> queryAllClasses();
    /**根据班级id查找班级信息*/
    public Classes queryClassesByClassesId(String classesId);
    /**通过学院名查找班级*/
    public List<String> queryClassesByCollegeName(String collegeName);
}
