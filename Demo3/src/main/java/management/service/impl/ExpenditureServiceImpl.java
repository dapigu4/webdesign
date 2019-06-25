package management.service.impl;

import management.dao.ExpenditureDao;
import management.pojo.Expenditure;
import management.service.ExpenditureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {
    @Resource
    private ExpenditureDao expenditureDao;
    @Override
    public Map addExpenditure(Expenditure expenditure) {
        Map<String,String> map = new HashMap<>();
        int result = expenditureDao.addExpenditure(expenditure);
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public List<Expenditure> showExpenditureByYear(Expenditure expenditure) {
        return expenditureDao.showExpenditureByYear(expenditure);
    }

    @Override
    public List<Expenditure> showExpenditureByMonth(Expenditure expenditure) {
        return expenditureDao.showExpenditureByMonth(expenditure);
    }

    @Override
    public List<Expenditure> showExpenditureByYearAndMonth(Expenditure expenditure) {
        return expenditureDao.showExpenditureByYearAndMonth(expenditure);
    }
}
