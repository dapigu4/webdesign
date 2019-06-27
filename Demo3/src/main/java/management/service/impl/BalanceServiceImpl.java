package management.service.impl;

import management.dao.BalanceDao;
import management.pojo.Balance;
import management.service.BalanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class BalanceServiceImpl implements BalanceService {
    @Resource
    private BalanceDao balanceDao;

    @Override
    public Map addBalanceIncome(Balance balance) {
        Map<String, String> map = new HashMap<>();
        int result = balanceDao.addBalanceIncome(balance);
        if (result > 0) {
            map.put("msg", "success");
        } else {
            map.put("msg", "fail");
        }
        return map;
    }

    @Override
    public Map addBalanceExpenditure(Balance balance) {
        Map<String, String> map = new HashMap<>();
        Double temp = balance.getBalanceMoney();
        balance.setBalanceMoney(-1 * temp);
        int result = balanceDao.addBalanceExpenditure(balance);
        if (result > 0) {
            map.put("msg", "success");
        } else {
            map.put("msg", "fail");
        }
        return map;
    }

    @Override
    public List<Balance> showBalanceByYearAndMonth(Balance balance) {
        return balanceDao.showBalanceByYearAndMonth(balance);
    }

    @Override
    public List<Balance> showBalanceOnCharts() {
        Balance balance = new Balance();
        balance.setBalanceDate(new Date());
        System.out.println(balance.getBalanceDate());
        List<Balance> list = balanceDao.showBalanceOnCharts(balance);
        List<Balance> list1 = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                Balance balance1 = new Balance();
                balance1.setBalanceMoney(0.0);
                list1.add(balance1);
            }
            for (Balance b:list) {
                list1.get(b.getId()-1).setBalanceMoney(b.getBalanceMoney());
            }
        return list1;
    }
}
