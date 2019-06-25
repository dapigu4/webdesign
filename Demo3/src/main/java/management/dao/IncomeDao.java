package management.dao;

import management.pojo.Income;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDao {
    int addIncome(Income income);
    List<Income> showIncomeByYear(Income income);//年
    List<Income> showIncomeByMonth(Income income);//月
    List<Income> showIncomeByYearAndMonth(Income income);//年加月
}
