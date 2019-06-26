package management.service.impl;

import management.dao.SalaryDao;
import management.dao.StaffDao;
import management.pojo.Salary;
import management.pojo.Staff;
import management.service.SalaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private SalaryDao salaryDao;
    @Resource
    private StaffDao staffDao;
    @Override
    public List<Salary> showSalary(Salary salary) {
        return salaryDao.showSalary(salary);
    }

    @Override
    public Map addSalary(Salary salary) {
        Map<String,String> map = new HashMap<>();
        Staff staff = new Staff();
        int result = -1;
        staff.setNumber(salary.getSalaryNumber());
        staff.setName(salary.getSalaryName());
        if(staffDao.showStaffInfoByNameAndNumber(staff)!=null){
            result = salaryDao.addSalary(salary);
        }
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }
}
