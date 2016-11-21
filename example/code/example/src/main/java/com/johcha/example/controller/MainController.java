package com.johcha.example.controller;

import com.johcha.example.model.User;
import com.johcha.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Johcha on 2016/11/14 0014.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    public MainController() {
        System.out.println("MainController");
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("title", "Spring MVC");
        return "hello";
    }

    @RequestMapping(value = "goMain", method = RequestMethod.GET)
    String goMain(
            HttpSession session
    ){
        User user = (User) session.getAttribute("user");
        if (user == null ) {
            return "login";
        } else {
            return "main";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST) //用来处理前台的login请求
//    private @ResponseBody
    String login(
            @RequestParam(value = "username", required = false)String username,
            @RequestParam(value = "password", required = false)String password,
            ModelMap model,
            HttpSession session
    ){
        User user = userService.getUserById(username);
        if (user == null || !user.getUserPwd().equals(password)) {
            return "login";
        } else {
            session.setAttribute("user", user);
            return "main";
        }
    }
}