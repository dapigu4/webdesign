package management.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Salary {
    private Integer id;
    @JSONField(format = "yyyy-MM-dd")
    private Date salaryDate;
    private String salaryNumber;
    private String salaryName;
    private Double salarySalary;

    public String getSalaryNumber() {
        return salaryNumber;
    }

    public void setSalaryNumber(String salaryNumber) {
        this.salaryNumber = salaryNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public Double getSalarySalary() {
        return salarySalary;
    }

    public void setSalarySalary(Double salarySalary) {
        this.salarySalary = salarySalary;
    }
}
