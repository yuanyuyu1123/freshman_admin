package com.rs.until;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class Sha256PasswordEncryptUtils {
    public static PasswordSalt encrypt(String password){
        String salt= UUID.randomUUID().toString();
        String passwordEncrypt = new Sha256Hash(password,salt,3).toString();
        PasswordSalt passwordSalt = new PasswordSalt();
        passwordSalt.setSalt(salt);
        passwordSalt.setPassword(passwordEncrypt);
        return passwordSalt;
    }

    public static String encrypt(String password,String salt){
        return new Sha256Hash(password,salt,3).toString();
    }
}
