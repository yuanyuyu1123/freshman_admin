package com.rs.until;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailUtils {
    public static void SendEmailInfoUser(String sendAddress, String title, String content, String copysendAddress)
            throws Exception {

        Properties properties = new Properties();

        // 设置服务器名称
        properties.setProperty("mail.host", "smtp.qq.com");

        // 设置邮件传输协议
        properties.setProperty("mail.transport.protocol", "smtp");

        // 设置是否要验证服务器用户名和密码
        properties.setProperty("mail.smtp.auth", "true");

        // 1.创建客户端与邮箱服务器的Session对象
        Session session = Session.getInstance(properties);

        // 2.开启session的debug模式，方便查看发送email的运行状态
        session.setDebug(true);

        // 3.通过session得到transport传输对象
        Transport transport = session.getTransport();

        // 4.使用用户名密码连接上邮箱服务器,此处的密码需要到邮箱开启服务设置
        //这是发送邮件的账号和密码
        transport.connect("smtp.qq.com", "2321682447@qq.com", "ywsjpxvrcmwnecci");

        // 5.创建邮件
        Message message = createSimpleMail(session, sendAddress, title, content, copysendAddress);

        // 6.发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    private static Message createSimpleMail(Session session, String sendAddress, String title, String content,
                                            String copysendAddress) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress("2321682447@qq.com"));
        // 指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendAddress));
        // 邮件的标题
        message.setSubject(title);
        // 邮件的内容
        message.setContent(content, "text/html;charset=UTF-8");

        // 设置抄送人
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(copysendAddress));

        return message;
    }
}
