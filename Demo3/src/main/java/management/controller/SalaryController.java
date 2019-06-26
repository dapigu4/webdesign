package management.controller;

import management.pojo.Salary;
import management.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @RequestMapping("/test")
    @ResponseBody
    public List<Salary> test() throws ParseException {
        Salary salary = new Salary();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-6-1");
        salary.setSalaryDate(date);
        return salaryService.showSalary(salary);
    }
}
