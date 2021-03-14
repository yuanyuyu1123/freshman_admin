package com.rs.controller;

import com.rs.entity.Administrator;
import com.rs.entity.AdministratorAdmin;
import com.rs.service.AdministratorAdminServlet;
import com.rs.service.AdministratorServlet;
import com.rs.until.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @Resource
    private AdministratorAdminServlet administratorAdminServlet;

    @Resource
    private AdministratorServlet administratorServlet;

    @Resource
    private AdministratorAdmin administratorAdmin;

    @Resource
    private Administrator administrator;

    @Resource
    private Verify verify;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseData login(@RequestBody AdministratorAdmin administratorAdmin){
        //验证参数是否合法
        if(!verify.verifyAdministratorAdmin(administratorAdmin)){
            return ResponseDataUtils.buildError("411","数据有误");
        }
        //获得用户密码
        String password = administratorAdmin.getPassword();
        AdministratorAdmin administratorAdminData = administratorAdminServlet.queryAdministratorAdmin(administratorAdmin.getAdminId());
        if(administratorAdminData==null){
            return ResponseDataUtils.buildError("411","用户不存在");
        }
        if(administratorAdminData.getState()==1) {
            return ResponseDataUtils.buildError("411", "账号已被禁用");
        }
        //判断密码是否相同
        if(Sha256PasswordEncryptUtils.encrypt(password,administratorAdminData.getSalt()).equals(administratorAdminData.getPassword())){
            //获得token
            Administrator administrator = administratorServlet.queryAdministratorById(administratorAdmin.getAdminId());
            Map<String, String> map = new HashMap<>();
            map.put("adminId", administrator.getAdminId());
            map.put("name", administrator.getName());
            String token = JWTUtil.createToken(map);
            System.out.println(token);
            return ResponseDataUtils.buildSuccess("200","登录成功",token);
        }else {
            return ResponseDataUtils.buildError("411","密码有误");
        }
    }

    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResponseData register(@RequestBody AdministratorParam administratorParam) {

        //获得管理员对象
        Administrator administrator = AdministratorUtils.assignAdministrator(administratorParam, this.administrator);

        //获得管理员管理对象
        AdministratorAdmin administratorAdmin = AdministratorUtils.assignAdministratorAdmin(administratorParam, this.administratorAdmin);

        //获得密码
        String password = administratorAdmin.getPassword();

        //验证管理员信息
        if(!verify.verifyAdministrator(administrator)&&!verify.verifyAdministratorAdmin(administratorAdmin)){
            return ResponseDataUtils.buildError("411","数据有误");
        }
        //查看数据库里是否已有该账号
        Administrator administrator1 = administratorServlet.queryAdministratorById(administrator.getAdminId());
        if (administrator1!=null){
            return ResponseDataUtils.buildError("411","账号已存在");
        }
        //获得token
        Map<String, String> map = new HashMap<>();
        map.put("adminId",administrator.getAdminId());
        map.put("name",administrator.getName());
        String token = JWTUtil.createToken(map);
        System.out.println(token);
        //保存管理员信息
        administratorAdmin.setState(0);
        PasswordSalt encrypt = Sha256PasswordEncryptUtils.encrypt(password);
        administratorAdmin.setPassword(encrypt.getPassword());
        administratorAdmin.setSalt(encrypt.getSalt());
        administratorServlet.saveAdministrator(administrator);
        administratorAdminServlet.saveAdministratorAdmin(administratorAdmin);
        return ResponseDataUtils.buildSuccess("200","注册成功",token);
    }
}
