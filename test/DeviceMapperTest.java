package management.test;

import management.pojo.Device;
import management.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeviceMapperTest {
    @Resource
    private DeviceService deviceService;

    @Test
    public void test1(){
        System.out.println(deviceService.showDevice());
    }

    @Test
    public void test2(){
        Device device = new Device();
        device.setDeviceName("捞头");
        device.setDeviceCount(100);
        device.setDevicePrice(550.0);
        System.out.println(deviceService.addDevice(device));
    }

    @Test
    public void test3(){
        Device device = new Device();
        device.setDeviceName("捞头");
        System.out.println(deviceService.removeDevice(device));
    }
}
