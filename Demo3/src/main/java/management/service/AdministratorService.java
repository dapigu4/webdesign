package management.service;

import management.pojo.Administrator;

import java.util.List;
import java.util.Map;

public interface AdministratorService {
    Map findAdministratorByAccountAndPassword(Administrator admin);
    Map addAdministrator(Administrator admin);
    Map updateAdministratorPassword(Administrator admin);
    Map findAdministratorByAccountAndMail(Administrator admin);
    List<Administrator> findAllAdministrator();
    Map removeAdministratorByAccount(Administrator admin);
    Administrator show();
}
