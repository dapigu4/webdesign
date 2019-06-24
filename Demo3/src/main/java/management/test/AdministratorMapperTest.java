package management.test;

import management.pojo.Administrator;
import management.service.AdministratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdministratorMapperTest {
//    @Resource(name = "userService")
//    private UserService us;
//    @Test
//    public void Test1(){
//        System.out.println(us.getUserByUsername("dapi"));
//    }
    @Resource
    private AdministratorService administratorService;


    @Test
    public void Test1(){//修改密码测试
        Administrator admin = new Administrator();
        admin.setAccount("admin");
        admin.setPassword("admin");
        administratorService.updateAdministratorPassword(admin);
    }

    @Test
    public void Test2(){//登录测试
        Administrator admin = new Administrator();
        admin.setAccount("admin");
        admin.setPassword("admin");
        System.out.println(administratorService.findAdministratorByAccountAndPassword(admin));
    }


    @Test
    public void Test3(){//注册测试
        Administrator admin = new Administrator();
        admin.setAccount("dapigu");
        admin.setPassword("123");
        admin.setEmail("1232342@qedc.com");
        admin.setPhone("15412334632");
        admin.setRegister_time(new Date());
        administratorService.addAdministrator(admin);
    }

    @Test
    public void Test4(){//忘记密码测试
        Administrator admin = new Administrator();
        admin.setAccount("admin");
        admin.setEmail("1194362899@qq.com");
        System.out.println(administratorService.findAdministratorByAccountAndMail(admin));
    }


    @Test
    public void Test5(){//查看全部管理员测试
        List<Administrator> list =  administratorService.findAllAdministrator();
       for(Administrator administrator : list){
           System.out.println(administrator.getAccount());
       }
    }

    @Test
    public void Test6(){//删除测试
        Administrator admin = new Administrator();
        admin.setAccount("dapigu");
        administratorService.removeAdministratorByAccount(admin);
    }

}
