package com.rs.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class Student implements Serializable {

    /** 学号*/
    private String stuId;

    /**姓名*/
    private String name;

    /**性别*/
    private String sex;

    /**二级学院*/
    private String collegeName;

    /**班级id*/
    private String classesId;

    /**班级*/
    private String classes;
    /**签到信息，是或否*/
    private String signIn;

    /**宿舍*/
    private String dormId;

    /**学费*/
    private BigDecimal tuition;

    /**是否交了学费*/
    private String payTuition;

    public Student() {
    }

    public Student(String stuId, String name, String sex, String collegeName, String classesId, String classes, String signIn, String dormId, BigDecimal tuition, String payTuition) {
        this.stuId = stuId;
        this.name = name;
        this.sex = sex;
        this.collegeName = collegeName;
        this.classesId = classesId;
        this.classes = classes;
        this.signIn = signIn;
        this.dormId = dormId;
        this.tuition = tuition;
        this.payTuition = payTuition;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSignIn() {
        return signIn;
    }

    public void setSignIn(String signIn) {
        this.signIn = signIn;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }

    public String getPayTuition() {
        return payTuition;
    }

    public void setPayTuition(String payTuition) {
        this.payTuition = payTuition;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", classesId='" + classesId + '\'' +
                ", classes='" + classes + '\'' +
                ", signIn='" + signIn + '\'' +
                ", dormId='" + dormId + '\'' +
                ", tuition=" + tuition +
                ", payTuition='" + payTuition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(stuId, student.stuId) &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(collegeName, student.collegeName) &&
                Objects.equals(classesId, student.classesId) &&
                Objects.equals(classes, student.classes) &&
                Objects.equals(signIn, student.signIn) &&
                Objects.equals(dormId, student.dormId) &&
                Objects.equals(tuition, student.tuition) &&
                Objects.equals(payTuition, student.payTuition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, name, sex, collegeName, classesId, classes, signIn, dormId, tuition, payTuition);
    }
}