package management.service;

import management.pojo.Salary;

import java.util.List;
import java.util.Map;

public interface SalaryService {
    List<Salary> showSalary(Salary salary);
    Map addSalary(Salary salary);
}
