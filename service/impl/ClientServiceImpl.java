package management.service.impl;

import management.dao.ClientDao;
import management.pojo.Client;
import management.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientDao clientDao;

    @Override
    public List<Client> showClient() {
        List<Client> list = clientDao.showClient();
        for (Client client:list) {
            if("m".equals(client.getClientSex())){
                client.setClientSex("男");
            }else {
                client.setClientSex("女");
            }
        }
        return list;
    }

    @Override
    public Map addClient(Client client) {
        Map<String,String> map = new HashMap<>();
        if(client.getClientSex().equals("男")){
            client.setClientSex("m");
        }else if(client.getClientSex().equals("女")){
            client.setClientSex("f");
        }else {
            client.setClientSex("u");
        }
        int result = clientDao.addClient(client);
        if(result >0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map removeClient(Client client) {
        Map<String,String> map = new HashMap<>();
        int result = clientDao.removeClient(client);
        if(result >0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map findClient(Client client) {
        Map<String,String> map = new HashMap<>();
        Client temp = clientDao.findClient(client);
        if(temp != null){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }
}
