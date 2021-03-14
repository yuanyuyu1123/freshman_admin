package com.rs.dao;

import com.rs.entity.Dorm;

import java.util.List;

public interface DormDao {
    /**查找所有宿舍*/
    public List<Dorm> queryAllDorm();
    /**查找宿舍根据班级id*/
    public List<Dorm> queryDormByClassesId(String classesId);
    /**根据宿舍id查找宿舍*/
    public Dorm queryDormByDormId(String dormId);
    /**将宿舍的人数+1*/
    public void addPeople(String dormId);

}
