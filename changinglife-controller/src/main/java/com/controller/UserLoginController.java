package com.controller;

import com.entrty.UserLogin;
import com.service.loginstatus.LoginStatusService;
import com.service.userlogin.UserLoginService;
import com.vo.ResponseVO;
import com.vo.UserLoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private LoginStatusService loginStatusService;

    /**
     * 去往登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "me/userLogin";
    }

    /**
     * 进行登录的操作，1.管理者界面，2.创作者界面
     * @param userLoginVO
     * @return
     */
    @RequestMapping("/inLogin")
    public ModelAndView inLogin(UserLoginVO userLoginVO) {
        ModelAndView modelAndView = new ModelAndView();
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userLoginVO,userLogin);
        String userId = userLoginService.loginGetId(userLogin);
        if(userLoginService.loginGetById(userLogin) > 0) {
            modelAndView.addObject("userId",userId);
            switch (loginStatusService.getId(userId)) {
                case 1:{
                    modelAndView.setViewName("admin");
                }break;
                case 2:{
                    modelAndView.setViewName("creators");
                }break;
                default:{
                    modelAndView.setViewName("error");
                }break;
            }
        } else {
            modelAndView.addObject("Login", userLoginVO);
            modelAndView.setViewName("me/userLogin");
        }
        return modelAndView;
    }
}
