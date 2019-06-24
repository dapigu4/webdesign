package management.dao;

import management.pojo.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    Staff showStaffInfoByName(Staff staff);
    int addStaff(Staff staff);
    int removeStaffByName(Staff staff);
    List<Staff> showAllStaff();
    Staff showStaffInfoByNumber(Staff staff);
    int removeStaffByNumber(Staff staff);
    Staff showStaffInfoByNameAndNumber(Staff staff);
}
