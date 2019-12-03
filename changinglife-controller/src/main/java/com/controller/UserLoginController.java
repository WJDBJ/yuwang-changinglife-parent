package com.controller;

import com.service.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/login")
    public String login() {
        return "/login/userLogin";
    }
}
