package management.service.impl;

import management.dao.DeviceDao;
import management.pojo.Device;
import management.service.DeviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
    @Resource
    private DeviceDao deviceDao;

    @Override
    public List<Device> showDevice() {
        return deviceDao.showDevice();
    }

    @Override
    public Map addDevice(Device device) {
        Map<String,String> map = new HashMap<>();
        int result = deviceDao.addDevice(device);
        if(result >0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map removeDevice(Device device) {
        Map<String,String> map = new HashMap<>();
        int result = deviceDao.removeDevice(device);
        if(result >0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map findDeviceCount(Device device) {
        Map<String,String> map = new HashMap<>();
        Device temp = deviceDao.findDeviceCount(device);
        if(temp != null && temp.getDeviceCount()>device.getDeviceCount()){
            map.put("msg","success");
        }else {
            map.put("msg","no");
        }
        return map;
    }
}
