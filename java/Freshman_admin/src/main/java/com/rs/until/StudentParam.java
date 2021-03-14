package com.rs.until;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class StudentParam implements Serializable {

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

    /**密码*/
    private String password;
    /**盐*/
    private String salt;
    /**状态，0为正常，1为禁用*/
    private Integer state;

    private String checkPassword;

    public StudentParam() {
    }

    public StudentParam(String stuId, String name, String sex, String collegeName, String classesId, String classes, String signIn, String dormId, BigDecimal tuition, String payTuition, String password, String salt, Integer state, String checkPassword) {
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
        this.password = password;
        this.salt = salt;
        this.state = state;
        this.checkPassword = checkPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    @Override
    public String toString() {
        return "StudentParam{" +
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
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentParam that = (StudentParam) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(collegeName, that.collegeName) &&
                Objects.equals(classesId, that.classesId) &&
                Objects.equals(classes, that.classes) &&
                Objects.equals(signIn, that.signIn) &&
                Objects.equals(dormId, that.dormId) &&
                Objects.equals(tuition, that.tuition) &&
                Objects.equals(payTuition, that.payTuition) &&
                Objects.equals(password, that.password) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, name, sex, collegeName, classesId, classes, signIn, dormId, tuition, payTuition, password, salt, state);
    }
}
