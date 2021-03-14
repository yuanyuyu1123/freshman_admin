package com.rs.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class AdministratorAdmin implements Serializable {
    /**管理员编号*/
    private String adminId;

    /**密码*/
    private String password;
    /**邮箱*/
    private String mail;

    /**盐*/
    private String salt;

    /**状态，0为正常，1为禁用*/
    private Integer state;

    public AdministratorAdmin() {
    }

    public AdministratorAdmin(String adminId, String password, String mail, String salt, Integer state) {
        this.adminId = adminId;
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
        return "AdministratorAdmin{" +
                "adminId='" + adminId + '\'' +
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
        AdministratorAdmin that = (AdministratorAdmin) o;
        return Objects.equals(adminId, that.adminId) &&
                Objects.equals(password, that.password) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, password, mail, salt, state);
    }
}
