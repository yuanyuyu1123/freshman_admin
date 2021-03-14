package com.rs.test;

import com.rs.until.JWTUtil;
import com.rs.until.MailUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {

    @Test
    public void test1(){
        /*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.rs.config");
        StudentAdminServlet studentAdminServlet = (StudentAdminServlet) applicationContext.getBean("studentAdminServletImpl");
        StudentAdmin studentAdmin = new StudentAdmin("21010436", "1234567890");
        String password = studentAdminServlet.queryStudentPasswordById(studentAdmin.getStuId());
        System.out.println(password);*/
    }

    @Test
    public void test2() throws Exception {
            MailUtils.SendEmailInfoUser("yuanyuyu1123@gmail.com","重置密码","新密码:1123","");
    }

    @Test
    public void test3(){
        Map<String, Object> map = JWTUtil.verifyToken("eyJUeXBlIjoiSnd0IiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJPYmplY3RNYXAiOnsic3R1SWQiOiIyMTAxMDQxOSIsIm5hbWUiOiLoooHlh6TljasifSwiZXhwIjoxNjE1Mjc2NTEzfQ.Y5TQ0k5ut26c0V2nDUEWSUVQm3-B4hIQwl1hB7RdV4I");
        System.out.println(map);
    }

    @Test
    public void test4(){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("stuId","21010436");
        hashMap.put("name","袁凤卫");
        String token = JWTUtil.createToken(hashMap);
        System.out.println(token);
        Map<String, Object> stringObjectMap = JWTUtil.verifyToken(token);
        System.out.println(stringObjectMap);
    }

}
