package com.controller;

import com.entrty.UserLogin;
import com.service.userlogin.UserLoginService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "me/userLogin";
    }

    @RequestMapping("/inLogin")
    @ResponseBody
    public ResponseVO inLogin(UserLogin userLogin) {
        if(userLoginService.loginGetById(userLogin) > 0) {
            return ResponseVO.newBuilder().code("200").msg("登录成功！欢迎回来!").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("登录失败！").data(userLogin).build();
        }
    }
}
