package management.test;

import management.pojo.Income;
import management.service.IncomeService;
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
public class IncomeMapperTest {
    @Resource
    private IncomeService incomeService;

    @Test
    public void test1(){
        Income income = new Income();
        income.setIncomeDate(new Date());
        income.setIncomeMoney(5000.0);
        income.setIncomeSource("拿去嫖了");
        System.out.println(incomeService.addIncome(income));
    }

    @Test
    public void test2() throws ParseException {
        Income income = new Income();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-1-1");
        income.setIncomeDate(date);
        System.out.println(incomeService.showIncomeByYear(income));
    }

    @Test
    public void test3() throws ParseException {
        Income income = new Income();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-2-1");
        income.setIncomeDate(date);
        System.out.println(incomeService.showIncomeByMonth(income));
    }

    @Test
    public void test4() throws ParseException {
        Income income = new Income();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-1-9");
        income.setIncomeDate(date);
        System.out.println(incomeService.showIncomeByDay(income));
    }
}
