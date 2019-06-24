package management.service;

import management.pojo.Income;

import java.util.List;
import java.util.Map;

public interface IncomeService {
    Map addIncome(Income income);
    List<Income> showIncomeByYear(Income income);
    List<Income> showIncomeByMonth(Income income);
    List<Income> showIncomeByDay(Income income);
}
