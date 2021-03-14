package com.rs.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class Classes implements Serializable {
    /**班级号*/
    private String classesId;
    /**学院名*/
    private String collegeName;
    /**班级人数*/
    private Integer classesNumber;
    /**专业*/
    private String major;
    /**专业费用*/
    private BigDecimal majorTuition;

    public Classes() {
    }

    public Classes(String classesId, String collegeName, Integer classesNumber, String major, BigDecimal majorTuition) {
        this.classesId = classesId;
        this.collegeName = collegeName;
        this.classesNumber = classesNumber;
        this.major = major;
        this.majorTuition = majorTuition;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Integer getClassesNumber() {
        return classesNumber;
    }

    public void setClassesNumber(Integer classesNumber) {
        this.classesNumber = classesNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public BigDecimal getMajorTuition() {
        return majorTuition;
    }

    public void setMajorTuition(BigDecimal majorTuition) {
        this.majorTuition = majorTuition;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classesId='" + classesId + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", classesNumber=" + classesNumber +
                ", major='" + major + '\'' +
                ", majorTuition=" + majorTuition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return Objects.equals(classesId, classes.classesId) &&
                Objects.equals(collegeName, classes.collegeName) &&
                Objects.equals(classesNumber, classes.classesNumber) &&
                Objects.equals(major, classes.major) &&
                Objects.equals(majorTuition, classes.majorTuition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classesId, collegeName, classesNumber, major, majorTuition);
    }
}