package management.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class MailUtil {
    public static String sendMail(String mail){
        String code = "";
        final Properties properties = System.getProperties();
        properties.put("mail.smtp.host","smtp.163.com");
        properties.put("mail.smtp.auth","true");

        properties.put("mail.user","test123456yasuo@163.com");
        properties.put("mail.password","abc123456789");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = properties.getProperty("mail.user");
                String password = properties.getProperty("mail.password");
                return new PasswordAuthentication(username,password);
            }
        };

        Session mailSession = Session.getInstance(properties,authenticator);

        MimeMessage message = new MimeMessage(mailSession);

        String username = properties.getProperty("mail.user");
        try {
            InternetAddress from = new InternetAddress(username);
            message.setFrom(from);

            InternetAddress to = new InternetAddress(mail);
            message.setRecipient(MimeMessage.RecipientType.TO,to);

            message.setSubject("找回密码的验证码");
            Random random = new Random();
            int temp;
            for(int i=0;i<4;i++){
                temp = random.nextInt(10);
                code += temp;
            }
            message.setContent(code,"text/html;charset=UTF-8");

            Transport.send(message);

        }catch (AddressException e){
            e.printStackTrace();
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return code;
    }
}
