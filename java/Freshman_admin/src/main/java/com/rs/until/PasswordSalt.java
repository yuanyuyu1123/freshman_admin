package com.rs.until;

import java.util.Objects;

public class PasswordSalt {
    private String password;
    private String salt;

    public PasswordSalt() {
    }

    public PasswordSalt(String password, String salt) {
        this.password = password;
        this.salt = salt;
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

    @Override
    public String toString() {
        return "PasswordSalt{" +
                "password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordSalt that = (PasswordSalt) o;
        return Objects.equals(password, that.password) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, salt);
    }
}
