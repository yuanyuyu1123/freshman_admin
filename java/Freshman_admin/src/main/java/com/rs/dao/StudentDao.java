package com.rs.dao;

import com.rs.entity.Student;

import java.util.List;

/**操作学生信息*/
public interface StudentDao {
    /**根据学院查询学生信息*/
    List<Student> queryStudentByCollegeName(String collegeName);
    /**根据班级查询学生信息*/
    List<Student> queryStudentByClasses(String collegeName, String classes);
    /**根据宿舍id查找学生*/
    List<Student> queryStudentByDormId(String dormId);
    /**根据stuId查询学生信息*/
    Student queryStudentById(String stuId);
    /**根据stuId更新学生信息*/
    void updateStudent(Student student);
    /**保存学生信息*/
    void saveStudent(Student student);
    /**删除学生信息*/
    void deleteStudent(String stuId);
}
