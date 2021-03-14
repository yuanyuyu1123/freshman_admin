package com.rs.until;

import com.rs.entity.Administrator;
import com.rs.entity.AdministratorAdmin;
import org.springframework.stereotype.Component;

/**用于控制器接收前端Administrator数据*/
@Component
public class AdministratorUtils {
    public static Administrator assignAdministrator(AdministratorParam administratorParam, Administrator administrator){
        administrator.setAdminId(administratorParam.getAdminId());
        administrator.setName(administratorParam.getName());
        administrator.setSex(administratorParam.getSex());
        return administrator;
    }

    public static AdministratorAdmin assignAdministratorAdmin(AdministratorParam administratorParam, AdministratorAdmin administratorAdmin){
        administratorAdmin.setAdminId(administratorParam.getAdminId());
        administratorAdmin.setPassword(administratorParam.getPassword());
        administratorAdmin.setMail(administratorParam.getMail());
        return administratorAdmin;
    }
}
