package management.service;

import management.pojo.Balance;

import java.util.List;
import java.util.Map;

public interface BalanceService {
    Map addBalanceIncome(Balance balance);
    Map addBalanceExpenditure(Balance balance);
    List<Balance> showBalanceByYearAndMonth(Balance balance);
}
