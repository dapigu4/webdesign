package management.service;

import management.pojo.Expenditure;

import java.util.List;
import java.util.Map;


public interface ExpenditureService {
    Map addExpenditure(Expenditure expenditure);
    List<Expenditure> showExpenditureByYear(Expenditure expenditure);
    List<Expenditure> showExpenditureByMonth(Expenditure expenditure);
    List<Expenditure> showExpenditureByDay(Expenditure expenditure);
}
