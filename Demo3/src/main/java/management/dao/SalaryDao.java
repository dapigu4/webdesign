package management.dao;

import management.pojo.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryDao {
    List<Salary> showSalary(Salary salary);
    int addSalary(Salary salary);
}
