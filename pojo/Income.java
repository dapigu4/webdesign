package management.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Income {
    private Integer id;
    @JSONField(format = "yyyy-MM-dd")
    private Date incomeDate;
    private String incomeSource;
    private Double incomeMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public Double getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(Double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }
}
