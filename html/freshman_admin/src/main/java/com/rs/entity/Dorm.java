package com.rs.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class Dorm implements Serializable {
    /**宿舍id*/
    private String dormId;
    /**班级id*/
    private String classesId;
    /**班级*/
    private String classes;
    /**宿舍当前人数，最多6人*/
    private Integer dormNumber;
    /**男生或女生宿舍*/
    private String sex;
    /**住宿费*/
    private BigDecimal cost;

    public Dorm() {
    }

    public Dorm(String dormId, String classesId, String classes, Integer dormNumber, String sex, BigDecimal cost) {
        this.dormId = dormId;
        this.classesId = classesId;
        this.classes = classes;
        this.dormNumber = dormNumber;
        this.sex = sex;
        this.cost = cost;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
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

    public Integer getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(Integer dormNumber) {
        this.dormNumber = dormNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "dormId='" + dormId + '\'' +
                ", classesId='" + classesId + '\'' +
                ", classes='" + classes + '\'' +
                ", dormNumber=" + dormNumber +
                ", sex='" + sex + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dorm dorm = (Dorm) o;
        return Objects.equals(dormId, dorm.dormId) &&
                Objects.equals(classesId, dorm.classesId) &&
                Objects.equals(classes, dorm.classes) &&
                Objects.equals(dormNumber, dorm.dormNumber) &&
                Objects.equals(sex, dorm.sex) &&
                Objects.equals(cost, dorm.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dormId, classesId, classes, dormNumber, sex, cost);
    }
}
