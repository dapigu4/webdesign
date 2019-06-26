package management.dao;

import management.pojo.Balance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceDao {
    int addBalanceIncome(Balance balance);
    int addBalanceExpenditure(Balance balance);
    List<Balance> showBalanceByYearAndMonth(Balance balance);
}
