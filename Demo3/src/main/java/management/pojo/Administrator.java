package management.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Administrator {
    private Integer id;
    private String account;
    private String password;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前台往后台传Date数据
    @JSONField(format = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//后台往前台传Date数据
    private Date register_time;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
