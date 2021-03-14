package com.rs.until;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class AdministratorParam implements Serializable {
    /**管理员编号*/
    private String adminId;

    /**姓名*/
    private String name;

    /**性别*/
    private String sex;

    /**密码*/
    private String password;
    /**邮箱*/
    private String mail;

    /**盐*/
    private String salt;

    /**状态，0为正常，1为禁用*/
    private Integer state;

    public AdministratorParam() {
    }

    public AdministratorParam(String adminId, String name, String sex, String password, String mail, String salt, Integer state) {
        this.adminId = adminId;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.mail = mail;
        this.salt = salt;
        this.state = state;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        return "AdministratorParam{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministratorParam that = (AdministratorParam) o;
        return Objects.equals(adminId, that.adminId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(password, that.password) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, name, sex, password, mail, salt, state);
    }
}
