package com.rs.dao;

import com.rs.entity.StudentAdmin;

public interface StudentAdminDao {
    /**根据stuId查找学生密码*/
    StudentAdmin queryStudentAdmin(String stuId);

    /**更新学生密码*/
    void updateStudentAdmin(StudentAdmin studentAdmin);

    /**保存学生密码*/
    void saveStudentAdmin(StudentAdmin studentAdmin);

    /**删除学生管理信息*/
    void deleteStudentPasswordById(String stuId);

}
