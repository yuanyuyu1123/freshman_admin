package com.rs.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class College implements Serializable {
    /**学院id*/
    private String collegeId;
    /**学院名*/
    private String collegeName;

    public College() {
    }

    public College(String collegeId, String collegeName) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "School{" +
                "collegeId='" + collegeId + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College school = (College) o;
        return Objects.equals(collegeId, school.collegeId) &&
                Objects.equals(collegeName, school.collegeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collegeId, collegeName);
    }
}
