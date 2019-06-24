package management.service.impl;

import management.dao.IncomeDao;
import management.pojo.Income;
import management.service.IncomeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {
    @Resource
    private IncomeDao incomeDao;
    @Override
    public Map addIncome(Income income) {
        Map<String,String> map = new HashMap<>();
        int result = incomeDao.addIncome(income);
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public List<Income> showIncomeByYear(Income income) {
        return incomeDao.showIncomeByYear(income);
    }

    @Override
    public List<Income> showIncomeByMonth(Income income) {
        return incomeDao.showIncomeByMonth(income);
    }

    @Override
    public List<Income> showIncomeByDay(Income income) {
        return incomeDao.showIncomeByDay(income);
    }
}
