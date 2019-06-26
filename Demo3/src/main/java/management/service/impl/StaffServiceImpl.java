package management.service.impl;

import management.dao.StaffDao;
import management.pojo.Staff;
import management.service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;
    @Override
    public Staff showStaffInfoByName(Staff staff) {
        return staffDao.showStaffInfoByName(staff);
    }

    @Override
    public List<Staff> showAllStaff() {
        List<Staff> list = staffDao.showAllStaff();
        for (Staff staff:list) {
            if("m".equals(staff.getSex())){
                staff.setSex("男");
            }else {
                staff.setSex("女");
            }
        }
        return list;
    }

    @Override
    public Map addStaff(Staff staff) {
        if(staff.getSex().equals("男")){
            staff.setSex("m");
        }else if(staff.getSex().equals("女")){
            staff.setSex("f");
        }else {
            staff.setSex("u");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        staff.setNumber(simpleDateFormat.format(new Date()));
        int result = staffDao.addStaff(staff);
        Map<String,String> map = new HashMap<>();
        if (result>0) {
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public void removeStaffByName(Staff staff) {
        staffDao.removeStaffByName(staff);
    }

    @Override
    public Map showStaffInfoByNumber(Staff staff) {
        Map<String,String> map = new HashMap<>();
        if(staffDao.showStaffInfoByNumber(staff)!=null){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map removeStaffByNumber(Staff staff) {
        Map<String,String> map = new HashMap<>();
           int result = staffDao.removeStaffByNumber(staff);
        if (result>0) {
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
           return map;
    }
}
