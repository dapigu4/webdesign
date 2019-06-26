package management.test;

import management.pojo.Salary;
import management.service.SalaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SalaryMapperTest {
    @Resource
    private SalaryService salaryService;

    @Test
    public void test1() throws ParseException {
        Salary salary = new Salary();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-6-1");
        salary.setSalaryDate(date);
        System.out.println(salaryService.showSalary(salary));
    }

    @Test
    public void test2(){
        Salary salary = new Salary();
        salary.setSalaryDate(new Date());
        salary.setSalaryName("小华");
        salary.setSalarySalary(2000.0);
        salary.setSalaryNumber("3521");
        System.out.println(salaryService.addSalary(salary));
    }
}
