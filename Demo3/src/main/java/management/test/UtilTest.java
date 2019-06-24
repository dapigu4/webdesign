package management.test;

import management.util.MailUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilTest {
    @Test
    public void test1(){
        System.out.println(MailUtil.sendMail("1194362899@qq.com"));
    }
    @Test
    public void test2(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(simpleDateFormat.format(new Date()));

    }
}
