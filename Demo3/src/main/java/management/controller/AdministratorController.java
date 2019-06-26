package management.controller;

import management.pojo.Administrator;
import management.service.AdministratorService;
import management.util.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @Resource
    private AdministratorService administratorService;

    @RequestMapping("/login")
    @ResponseBody
    public Map login(@RequestBody Administrator admin){//登录
        return administratorService.findAdministratorByAccountAndPassword(admin);
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map register(@RequestBody Administrator admin){//注册
        return administratorService.addAdministrator(admin);
    }

    @RequestMapping("/forget")
    @ResponseBody
    public Map forget(@RequestBody Administrator admin){//返回验证码
        return administratorService.findAdministratorByAccountAndMail(admin);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public Map modify(@RequestBody Administrator admin){//修改密码
        return administratorService.updateAdministratorPassword(admin);
    }

    @RequestMapping("/show")
    @ResponseBody
    public Administrator show(){
        return administratorService.show();
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map remove(@RequestBody Administrator admin){
        return administratorService.removeAdministratorByAccount(admin);
    }

    @RequestMapping("/logout")
    public void logout(){
        UserContext.setCurrentAdministrator(null);
    }

}
