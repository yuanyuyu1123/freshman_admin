package com.rs.until;

import com.rs.entity.Administrator;
import com.rs.entity.AdministratorAdmin;
import com.rs.entity.Student;
import com.rs.entity.StudentAdmin;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;


/**
 * 用于验证前端传来的数据是否合法
 */
@Component
public class Verify {
    /**验证Student是否满足格式，学号必须以21开头*/
    public Boolean verifyStudent(Student student){
        return (student != null)
                && (student.getStuId()!=null)
                &&(student.getStuId().length() == 8)
                &&(student.getStuId().startsWith("21"))
                && (student.getName()!=null)
                && (student.getName().length() > 1)
                && ("男".equals(student.getSex()) || "女".equals(student.getSex()))
                && (student.getCollegeName()!=null)
                && (student.getClasses()!=null)
                && (student.getCollegeName().length() > 0)
                && (student.getClassesId().length() > 0)
                && (student.getClasses().length() > 0)
                && ("是".equals(student.getPayTuition()) || "否".equals(student.getPayTuition()));
    }

    /**验证StudentAdmin是否满足格式，学号必须以21开头*/
    public Boolean verifyStudentAdmin(StudentAdmin studentAdmin){
        return (studentAdmin!=null)
                &&(studentAdmin.getPassword()!=null)
                &&(studentAdmin.getPassword().length()<20)
                &&(studentAdmin.getPassword().length()>9)
                &&(studentAdmin.getStuId()!=null)
                &&(studentAdmin.getStuId().length()==8)
                &&(studentAdmin.getStuId().startsWith("21"));
    }

    /**验证Administrator是否满足格式*/
    public Boolean verifyAdministrator(Administrator administrator){
        return (administrator!=null)
                && (administrator.getAdminId()!=null)
                &&(administrator.getAdminId().length()==8)
                && (administrator.getName()!=null)
                &&(administrator.getName().length()>1)
                &&("男".equals(administrator.getSex())||"女".equals(administrator.getSex()));
    }

    /**验证AdministratorAdmin是否满足格式*/
    public Boolean verifyAdministratorAdmin(AdministratorAdmin administratorAdmin){
        return (administratorAdmin!=null)
                && (administratorAdmin.getAdminId()!=null)
                &&(administratorAdmin.getAdminId().length()==8)
                && (administratorAdmin.getPassword()!=null)
                &&(administratorAdmin.getPassword().length()>9
                && (administratorAdmin.getPassword().length()<20));
    }
}
