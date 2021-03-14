package com.rs.service.impl;

import com.rs.dao.StudentAdminDao;
import com.rs.entity.StudentAdmin;
import com.rs.service.StudentAdminServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class StudentAdminServletImpl implements StudentAdminServlet {
    @Resource
    private StudentAdminDao studentAdminDao;
    @Override
    public StudentAdmin queryStudentAdmin(String stuId) {
        StudentAdmin studentAdmin = studentAdminDao.queryStudentAdmin(stuId);
        return studentAdmin;
    }

    @Override
    public void updateStudentAdmin(StudentAdmin studentAdmin) {
        studentAdminDao.updateStudentAdmin(studentAdmin);
    }

    @Override
    public void saveStudentAdmin(StudentAdmin studentAdmin) {
        studentAdminDao.saveStudentAdmin(studentAdmin);
    }

    @Override
    public void deleteStudentPasswordById(String stuId) {
        studentAdminDao.deleteStudentPasswordById(stuId);
    }
}
