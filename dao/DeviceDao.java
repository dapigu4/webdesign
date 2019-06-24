package management.dao;

import management.pojo.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceDao {
    List<Device> showDevice();
    int addDevice(Device device);
    int removeDevice(Device device);
    Device findDeviceCount(Device device);
}
