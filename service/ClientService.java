package management.service;

import management.pojo.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ClientService {
    List<Client> showClient();
    Map addClient(Client client);
    Map removeClient(Client client);
    Map findClient(Client client);
}
