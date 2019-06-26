package management.dao;

import management.pojo.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao {
    List<Client> showClient();
    int addClient(Client client);
    int removeClient(Client client);
    List<Client> findClient(Client client);
}
