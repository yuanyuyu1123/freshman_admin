package com.rs.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class Administrator implements Serializable {
    /**管理员编号*/
    private String adminId;

    /**姓名*/
    private String name;

    /**性别*/
    private String sex;

    public Administrator() {
    }

    public Administrator(String adminId, String name, String sex) {
        this.adminId = adminId;
        this.name = name;
        this.sex = sex;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(adminId, that.adminId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, name, sex);
    }
}