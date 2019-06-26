package management.service.impl;

import management.dao.AdministratorDao;
import management.pojo.Administrator;
import management.service.AdministratorService;
import management.util.MailUtil;
import management.util.UserContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {
    @Resource
    private AdministratorDao administratorDao;
    @Override
    public Map findAdministratorByAccountAndPassword(Administrator admin) {
        Map<String,String> map = new HashMap<>();
        Administrator temp;
        if((temp = administratorDao.findAdministratorByAccountAndPassword(admin)) != null){
            map.put("msg",temp.getAccount());
            UserContext.setCurrentAdministrator(temp);
        }else {
            map.put("msg","");
        }
        return map;
    }

    @Override
    public List<Administrator> findAllAdministrator() {
        return administratorDao.findAllAdministrator();
    }

    @Override
    public Map addAdministrator(Administrator admin) {
        Map<String,String> map = new HashMap<>();
        admin.setRegister_time(new Date());
         int result = administratorDao.addAdministrator(admin);
        if (result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
         return map;
    }

    @Override
    public Map updateAdministratorPassword(Administrator admin) {
        Map<String,String> map = new HashMap<>();
        int result = administratorDao.updateAdministratorPassword(admin);
        if (result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map removeAdministratorByAccount(Administrator admin) {
        Map<String,String> map = new HashMap<>();
       int result =  administratorDao.removeAdministratorByAccount(admin);
       if (result>0){
           map.put("msg","success");
       }else {
           map.put("msg","fail");
       }
       return map;
    }

    @Override
    public Map findAdministratorByAccountAndMail(Administrator admin) {
        Map<String,String> map = new HashMap<>();
        if(administratorDao.findAdministratorByAccountAndMail(admin) !=null){
            map.put("msg", MailUtil.sendMail(admin.getEmail()));
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Administrator show() {
        return administratorDao.show(UserContext.getCurrentAdministrator());
    }
}
