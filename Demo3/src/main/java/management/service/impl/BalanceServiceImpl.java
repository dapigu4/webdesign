package management.service.impl;

import management.dao.BalanceDao;
import management.pojo.Balance;
import management.service.BalanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BalanceServiceImpl implements BalanceService{
    @Resource
    private BalanceDao balanceDao;

    @Override
    public Map addBalanceIncome(Balance balance) {
        Map<String,String> map = new HashMap<>();
        int result = balanceDao.addBalanceIncome(balance);
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
         return map;
    }

    @Override
    public Map addBalanceExpenditure(Balance balance) {
        Map<String,String>map = new HashMap<>();
        Double temp  = balance.getBalanceMoney();
        balance.setBalanceMoney(-1*temp);
        int result = balanceDao.addBalanceExpenditure(balance);
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public List<Balance> showBalanceByYearAndMonth(Balance balance) {
        return balanceDao.showBalanceByYearAndMonth(balance);
    }
}
