package management.test;


import management.pojo.Staff;
import management.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StaffMapperTest {
    @Resource
    private StaffService staffService;

    @Test
    public void Test1() {//查看某个员工信息
        Staff staff = new Staff();
        staff.setName("小田");
        System.out.println(staffService.showStaffInfoByName(staff));
    }

    @Test
    public void Test2() {//新增员工
        Staff staff = new Staff();
        staff.setName("小花");
        staff.setSex("女");
        staff.setPhone("53456245324");
        staff.setAddress("西四");
        staff.setEmail("1323@qwrf.com");
        staff.setHiredate(new Date());
        staffService.addStaff(staff);
    }

    @Test
    public void Test3() {//查看全部
        List<Staff> list = staffService.showAllStaff();
        for (Staff staff : list) {
            System.out.println(staff);
        }
    }

    @Test
    public void Test4() {//根据名字删除员工
       Staff staff = new Staff();
       staff.setName("小田");
       staffService.removeStaffByName(staff);
    }
    @Test
    public void Test5() {//根据编号删除员工
        Staff staff = new Staff();
        staff.setNumber("34652346");
        staffService.removeStaffByNumber(staff);
    }
}
