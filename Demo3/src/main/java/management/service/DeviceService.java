package management.service;

import management.pojo.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    List<Device> showDevice();
    Map addDevice(Device device);
    Map removeDevice(Device device);
    Map findDeviceCount(Device device);
}
