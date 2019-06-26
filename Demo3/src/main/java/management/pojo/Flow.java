package management.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Flow {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date flowDate;
    private String inOrOut;
    private String supplyOrDemand;
    private String productName;
    private String size;
    private Double perCost;
    private Double perSell;
    private Double total;
    private Integer count;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(Date flowDate) {
        this.flowDate = flowDate;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getSupplyOrDemand() {
        return supplyOrDemand;
    }

    public void setSupplyOrDemand(String supplyOrDemand) {
        this.supplyOrDemand = supplyOrDemand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPerCost() {
        return perCost;
    }

    public void setPerCost(Double perCost) {
        this.perCost = perCost;
    }

    public Double getPerSell() {
        return perSell;
    }

    public void setPerSell(Double perSell) {
        this.perSell = perSell;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
