package management.controller;

import management.pojo.Staff;
import management.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @RequestMapping("/showbyname")
    @ResponseBody
    public Staff showByName(@RequestBody Staff staff) {
        return staffService.showStaffInfoByName(staff);
    }

    @RequestMapping("/showall")
    @ResponseBody
    public List<Staff> showAll() {
        return staffService.showAllStaff();
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map register(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map remove(@RequestBody Staff staff) {
        return staffService.removeStaffByNumber(staff);
    }

    @RequestMapping("/showbynumber")
    @ResponseBody
    public Map showByNumber(@RequestBody Staff staff) {
        return staffService.showStaffInfoByNumber(staff);
    }

}
