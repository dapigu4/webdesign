package management.service;

import management.pojo.Staff;

import java.util.List;
import java.util.Map;

public interface StaffService {
    Staff showStaffInfoByName(Staff staff);
    Map addStaff(Staff staff);
    void removeStaffByName(Staff staff);
    List<Staff> showAllStaff();
    Map showStaffInfoByNumber(Staff staff);
    Map removeStaffByNumber(Staff staff);
}
