package management.controller;

import management.pojo.Salary;
import management.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Resource
    private SalaryService salaryService;

    @RequestMapping("/show")
    @ResponseBody
    public List<Salary> show(@RequestBody Salary salary){
       return salaryService.showSalary(salary);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Salary salary){
        return salaryService.addSalary(salary);
    }
}
