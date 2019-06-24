package management.test;

import management.pojo.Client;
import management.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ClientMapperTest {
    @Resource
    private ClientService clientService;

    @Test
    public void test1(){
        System.out.println(clientService.showClient());
    }

    @Test
    public void test2(){
        Client client = new Client();
        client.setClientName("付款后视镜对话框");
        client.setClientContact("jkfaafh安防科技");
        client.setClientAddress("gkdv色粉");
        client.setClientPhone("32536725341");
        client.setClientSex("m");
        client.setClientEmail("hjgujh@erdffgh.com");
        System.out.println(clientService.addClient(client));
    }


    @Test
    public void test3(){
        Client client = new Client();
        client.setClientName("付款后视镜对话框");
        System.out.println(clientService.removeClient(client));
    }

    @Test
    public void test4(){
        Client client = new Client();
        client.setClientName("付款后框");
        System.out.println(clientService.findClient(client));
    }
}
