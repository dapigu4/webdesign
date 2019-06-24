package management.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Device {
    private Integer id;
    private String deviceName;
    private Integer deviceCount;
    private Double devicePrice;
    @JSONField(format = "yyyy-MM-dd")
    private Date deviceDate;

    public Date getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(Date deviceDate) {
        this.deviceDate = deviceDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Double getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(Double devicePrice) {
        this.devicePrice = devicePrice;
    }
}
