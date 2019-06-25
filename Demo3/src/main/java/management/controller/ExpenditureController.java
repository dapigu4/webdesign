package management.controller;

import management.pojo.Expenditure;
import management.service.ExpenditureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/expenditure")
public class ExpenditureController {
    @Resource
    private ExpenditureService expenditureService;

    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Expenditure expenditure){
        return expenditureService.addExpenditure(expenditure);
    }

    @RequestMapping("/showexpenditurebyyear")
    @ResponseBody
    public List<Expenditure> showExpenditureByYear(@RequestBody Expenditure expenditure){
        return expenditureService.showExpenditureByYear(expenditure);
    }

    @RequestMapping("/showexpenditurebymonth")
    @ResponseBody
    public List<Expenditure> showExpenditureByMonth(@RequestBody Expenditure expenditure){
        return expenditureService.showExpenditureByMonth(expenditure);
    }

    @RequestMapping("/showexpenditurebyyearandmonth")
    @ResponseBody
    public List<Expenditure> showExpenditureByYearAndMonth(@RequestBody Expenditure expenditure){
        return expenditureService.showExpenditureByYearAndMonth(expenditure);
    }
}
