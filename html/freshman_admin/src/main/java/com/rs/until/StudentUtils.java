package com.rs.until;

import com.rs.entity.Student;
import com.rs.entity.StudentAdmin;
import org.springframework.stereotype.Component;

/**用于控制器接收前端student数据*/
@Component
public class StudentUtils {

    public static Student assignStudent(StudentParam studentParam,Student student){
        student.setStuId(studentParam.getStuId());
        student.setClassesId(studentParam.getClassesId());
        student.setName(studentParam.getName());
        student.setClasses(studentParam.getClasses());
        student.setCollegeName(studentParam.getCollegeName());
        student.setSex(studentParam.getSex());
        String classesId = studentParam.getStuId().substring(0, 6);
        student.setClassesId(classesId);
        return student;
    }

    public static StudentAdmin assignStudentAdmin(StudentParam studentParam,StudentAdmin studentAdmin){
        studentAdmin.setStuId(studentParam.getStuId());
        studentAdmin.setPassword(studentParam.getPassword());
        return studentAdmin;
    }
}
