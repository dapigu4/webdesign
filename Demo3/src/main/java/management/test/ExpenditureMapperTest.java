package management.test;

import management.pojo.Expenditure;
import management.service.ExpenditureService;
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
public class ExpenditureMapperTest {
    @Resource
    private ExpenditureService expenditureService;

    @Test
    public void test1(){
        Expenditure expenditure = new Expenditure();
        expenditure.setExpenditureDate(new Date());
        expenditure.setExpenditureUse("数据库大是大非狂欢节");
        expenditure.setExpenditureMoney(500.0);
        System.out.println(expenditureService.addExpenditure(expenditure));
    }

    @Test
    public void test2() throws ParseException {
        Expenditure expenditure = new Expenditure();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-1-1");
        expenditure.setExpenditureDate(date);
        System.out.println(expenditureService.showExpenditureByYear(expenditure));
    }


    @Test
    public void test3() throws ParseException {
        Expenditure expenditure = new Expenditure();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-4-1");
        expenditure.setExpenditureDate(date);
        System.out.println(expenditureService.showExpenditureByMonth(expenditure));
    }


    @Test
    public void test4() throws ParseException {
        Expenditure expenditure = new Expenditure();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-1-6");
        expenditure.setExpenditureDate(date);
        System.out.println(expenditureService.showExpenditureByDay(expenditure));
    }
}
