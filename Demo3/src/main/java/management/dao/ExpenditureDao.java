package management.dao;

import management.pojo.Expenditure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureDao {
    int addExpenditure(Expenditure expenditure);
    List<Expenditure> showExpenditureByYear(Expenditure expenditure);//年
    List<Expenditure> showExpenditureByMonth(Expenditure expenditure);//月
    List<Expenditure> showExpenditureByDay(Expenditure expenditure);//日
}
