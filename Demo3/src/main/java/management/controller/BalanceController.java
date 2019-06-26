package management.controller;

import management.pojo.Balance;
import management.service.BalanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/balance")
public class BalanceController {
    @Resource
    private BalanceService balanceService;

    @RequestMapping("/addIncome")
    @ResponseBody
    public Map addIncome(@RequestBody Balance balance){
        return balanceService.addBalanceIncome(balance);
    }

    @RequestMapping("/addExpenditure")
    @ResponseBody
    public Map addExpenditure(@RequestBody Balance balance){
        return balanceService.addBalanceExpenditure(balance);
    }

    @RequestMapping("/showbalance")
    @ResponseBody
    public List<Balance> showBalance(@RequestBody Balance balance){
        return balanceService.showBalanceByYearAndMonth(balance);
    }
}

