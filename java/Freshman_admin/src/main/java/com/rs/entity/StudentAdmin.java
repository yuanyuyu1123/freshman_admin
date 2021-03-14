package com.rs.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentAdmin {
    /**学号*/
    private String stuId;
    /**密码*/
    private String password;
    /**盐*/
    private String salt;
    /**状态，0为正常，1为禁用*/
    private Integer state;

    public StudentAdmin() {
    }

    public StudentAdmin(String stuId, String password, String salt, Integer state) {
        this.stuId = stuId;
        this.password = password;
        this.salt = salt;
        this.state = state;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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

    @Override
    public String toString() {
        return "StudentAdmin{" +
                "stuId='" + stuId + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAdmin that = (StudentAdmin) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(password, that.password) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, password, salt, state);
    }
}
