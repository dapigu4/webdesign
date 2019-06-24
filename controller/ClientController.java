package management.controller;

import management.pojo.Client;
import management.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Resource
    private ClientService clientService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Client> list(){
        return clientService.showClient();
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map register(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map remove(@RequestBody Client client){
        return clientService.removeClient(client);
    }

    @RequestMapping("/showbyname")
    @ResponseBody
    public Map showByName(@RequestBody Client client){
        return clientService.findClient(client);
    }
}
