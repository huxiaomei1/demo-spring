package cn.smbms.controller;

import cn.smbms.beans.User;
import cn.smbms.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("user")
public class UserController {
    private  final  static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("index.html")
    public String login() {
        System.out.println("登录");
        return "index";
    }

    @RequestMapping("dologin.html")
    public String doLogin (@RequestParam("userCode") String userName, @RequestParam("userPassword") String password) {
        User user = userService.login(userName,password);
        if (null!= user){
            System.out.println("查询到用户");
            return "redirect:/user/main.html";
        }else {
            return "index";
        }
    }

    @RequestMapping("main.html")
    public String main(){
        return "frame";
    }
}
