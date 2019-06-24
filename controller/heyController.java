package management.controller;


import management.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import management.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/user")
public class heyController {
    @Resource(name = "userService")
    private UserService us;

    @RequestMapping("/list")
    @ResponseBody
    public User list(Model model, @RequestParam String username){
        System.out.println("hello");
//        User user = new User();
//        user.setUsername("dapigu");
//        user.setPassword("123");
         User user = us.getUserByUsername(username);

//        model.addAttribute("user",us.getUserByUsername(username));
        System.out.println(user);
        return user;
    }

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("test1");
        return "welcome";
    }

}
