package management.test;

import management.pojo.Balance;
import management.service.BalanceService;
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
public class BalanceMapperTest {
    @Resource
    private BalanceService balanceService;

    @Test
    public void test1() throws ParseException {
        Balance balance = new Balance();
       Date date = new Date();
        balance.setBalanceDate(date);
        balance.setBalanceDetails("fa史蒂夫");
        balance.setBalanceMoney(300.0);
        System.out.println(balanceService.addBalanceIncome(balance));
    }

    @Test
    public void test2() throws ParseException{
        Balance balance = new Balance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-4-5");
        balance.setBalanceDate(date);
        balance.setBalanceDetails("fa发送到史");
        balance.setBalanceMoney(500.0);
        System.out.println(balanceService.addBalanceExpenditure(balance));
    }

    @Test
    public void test3() throws ParseException{
        Balance balance = new Balance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-4-5");
        balance.setBalanceDate(date);
       System.out.println( balanceService.showBalanceByYearAndMonth(balance));
    }
}
