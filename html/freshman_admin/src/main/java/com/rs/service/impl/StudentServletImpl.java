package com.rs.service.impl;

import com.rs.dao.StudentDao;
import com.rs.entity.Student;
import com.rs.service.StudentServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StudentServletImpl implements StudentServlet {
    @Resource
    private StudentDao studentDao;

    /**根据stuId查询学生信息*/
    @Override
    public Student queryStudentById(String stuId){
        Student student = studentDao.queryStudentById(stuId);
        return student;
    }

    /**根据stuId更新学生信息*/
    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    /**保存学生信息*/
    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    /**保存学生信息*/
    @Override
    public void deleteStudent(String stuId) {
        studentDao.deleteStudent(stuId);
    }

    /**根据学院查询学生信息*/
    @Override
    public List<Student> queryStudentByCollegeName(String collegeName) {
        List<Student> students = studentDao.queryStudentByCollegeName(collegeName);
        return students;
    }

    /**根据班级查询学生信息*/
    @Override
    public List<Student> queryStudentByClasses(String collegeName, String classes) {
        List<Student> students = studentDao.queryStudentByClasses(collegeName, classes);
        return students;
    }

    /**根据宿舍id查找学生*/
    @Override
    public List<Student> queryStudentByDormId(String dormId) {
        List<Student> students = studentDao.queryStudentByDormId(dormId);
        return students;
    }
}
