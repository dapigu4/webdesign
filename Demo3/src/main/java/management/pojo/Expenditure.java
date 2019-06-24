package management.pojo;

import java.util.Date;

public class Expenditure {
    private Integer id;
    private Date expenditureDate;
    private String expenditureUse;
    private Double expenditureMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpenditureDate() {
        return expenditureDate;
    }

    public void setExpenditureDate(Date expenditureDate) {
        this.expenditureDate = expenditureDate;
    }

    public String getExpenditureUse() {
        return expenditureUse;
    }

    public void setExpenditureUse(String expenditureUse) {
        this.expenditureUse = expenditureUse;
    }

    public Double getExpenditureMoney() {
        return expenditureMoney;
    }

    public void setExpenditureMoney(Double expenditureMoney) {
        this.expenditureMoney = expenditureMoney;
    }
}
