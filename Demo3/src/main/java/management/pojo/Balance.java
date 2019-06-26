package management.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Balance {
    private Integer id;
    @JSONField(format = "yyyy-MM-dd")
    private Date balanceDate;
    private String balanceDetails;
    private Double balanceMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getBalanceDetails() {
        return balanceDetails;
    }

    public void setBalanceDetails(String balanceDetails) {
        this.balanceDetails = balanceDetails;
    }

    public Double getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(Double balanceMoney) {
        this.balanceMoney = balanceMoney;
    }
}
