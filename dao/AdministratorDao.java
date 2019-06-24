package management.dao;

import management.pojo.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorDao {
    Administrator findAdministratorByAccountAndPassword(Administrator admin);
    int addAdministrator(Administrator admin);
    int updateAdministratorPassword(Administrator admin);
    Administrator findAdministratorByAccountAndMail(Administrator admin);
    List<Administrator> findAllAdministrator();
    int removeAdministratorByAccount(Administrator admin);
}
