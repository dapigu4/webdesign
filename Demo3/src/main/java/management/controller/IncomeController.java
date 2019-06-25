package management.controller;

import management.pojo.Income;
import management.service.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/income")
public class IncomeController {
    @Resource
    private IncomeService incomeService;

    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Income income){
        return incomeService.addIncome(income);
    }

    @RequestMapping("/showincomebyyear")
    @ResponseBody
    public List<Income> showIncomeByYear(@RequestBody Income income){
        return incomeService.showIncomeByYear(income);
    }

    @RequestMapping("/showincomebymonth")
    @ResponseBody
    public List<Income> showIncomeByMonth(@RequestBody Income income){
        return incomeService.showIncomeByMonth(income);
    }

    @RequestMapping("/showincomebyyearandmonth")
    @ResponseBody
    public List<Income> showIncomeByYearAndMonth(@RequestBody Income income){
        return incomeService.showIncomeByYearAndMonth(income);
    }
}
