package com.rs.controller;

import com.rs.entity.Student;
import com.rs.entity.StudentAdmin;
import com.rs.until.*;
import com.rs.service.StudentAdminServlet;
import com.rs.service.StudentServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentAdminServlet studentAdminServlet;

    @Resource
    private StudentServlet studentServlet;

    @Resource
    private StudentAdmin studentAdmin;

    @Resource
    private Student student;

    @Resource
    private Verify verify;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseData login(@RequestBody StudentParam studentParam){
        StudentAdmin studentAdmin = StudentUtils.assignStudentAdmin(studentParam, this.studentAdmin);
        //验证参数是否合法
        if(!verify.verifyStudentAdmin(studentAdmin)){
            return ResponseDataUtils.buildError("411","参数错误");
        }
        //查看用户是否存在
        StudentAdmin studentAdminData = studentAdminServlet.queryStudentAdmin(studentAdmin.getStuId());
        if(studentAdminData==null){
            return ResponseDataUtils.buildError("411","用户不存在");
        }
        //获得数据库中的密码
        String password = studentAdminData.getPassword();
        //获得盐
        String salt = studentAdminData.getSalt();
        //获得状态
        Integer state = studentAdminData.getState();
        //查看账号状态
        if(state!=0){
            return ResponseDataUtils.buildError("411", "账号已被禁用");
        }
        //判断密码是否相同
        if(password.equals(Sha256PasswordEncryptUtils.encrypt(studentAdmin.getPassword(),salt))){
            Student student = studentServlet.queryStudentById(studentAdmin.getStuId());
            Map<String, String> map = new HashMap<>();
            map.put("stuId", student.getStuId());
            map.put("name", student.getName());
            String token = JWTUtil.createToken(map);
            System.out.println(token);
            return ResponseDataUtils.buildSuccess("200","登陆成功",token);
        }else {
            return ResponseDataUtils.buildError("411","密码错误");
        }
    }

    /*
    * stu_id CHAR(8) PRIMARY KEY,
	name VARCHAR(10) NOT NULL,
	sex VARCHAR(2) NOT NULL,
	college_name VARCHAR(20) NOT NULL,
	classes_id CHAR(6)NOT NULL,
	classes VARCHAR(6) NOT NULL,
	dorm_id VARCHAR(5),
	sign_in VARCHAR(2),
	tuition DECIMAL(9,2) COMMENT '学费',
	pay_tuition VARCHAR(2)NOT NULL DEFAULT '否' COMMENT '是否交了学费'*/
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseData register(@RequestBody StudentParam studentParam) {
        //获得学生对象
        Student student = StudentUtils.assignStudent(studentParam, this.student);
        student.setPayTuition("否");
        student.setTuition(new BigDecimal("0.00"));
        System.out.println(student);

        //设置学生管理对象
        StudentAdmin studentAdmin = StudentUtils.assignStudentAdmin(studentParam, this.studentAdmin);
        System.out.println(studentAdmin);

        //验证学生信息
        if(!verify.verifyStudent(student)){
            return ResponseDataUtils.buildError("411","输入错误");
        }
        System.out.println(studentAdmin);
        //验证学生管理格式
        if(!verify.verifyStudentAdmin(studentAdmin)){
            return ResponseDataUtils.buildError("411","输入错误");
        }
        //查看数据库里是否已有该账号
        Student student1 = studentServlet.queryStudentById(student.getStuId());
        if (student1!=null){
            return ResponseDataUtils.buildError("411","账号已存在");
        }
        //获得token
        Map<String, String> map = new HashMap<>();
        map.put("stuId",student.getStuId());
        map.put("name",student.getName());
        String token = JWTUtil.createToken(map);
        System.out.println(token);
        //保存学生信息
        PasswordSalt encrypt = Sha256PasswordEncryptUtils.encrypt(studentAdmin.getPassword());
        studentAdmin.setSalt(encrypt.getSalt());
        studentAdmin.setPassword(encrypt.getPassword());
        studentAdmin.setState(0);
        studentServlet.saveStudent(student);
        studentAdminServlet.saveStudentAdmin(studentAdmin);
        return ResponseDataUtils.buildSuccess("200","注册成功",token);
    }
}
