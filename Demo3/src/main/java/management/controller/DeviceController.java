package management.controller;

import management.pojo.Device;
import management.service.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/device")
public class DeviceController {
    @Resource
    private DeviceService deviceService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Device> list(){
        return deviceService.showDevice();
    }

    @RequestMapping("/regiser")
    @ResponseBody
    public Map register(@RequestBody Device device){
        return deviceService.addDevice(device);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map remove(@RequestBody Device device){
        return deviceService.removeDevice(device);
    }

    @RequestMapping("/showbyname")
    @ResponseBody
    public Map showByName(@RequestBody Device device){
        return deviceService.findDeviceCount(device);
    }
}
