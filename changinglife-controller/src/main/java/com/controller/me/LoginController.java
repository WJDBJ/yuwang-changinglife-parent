package com.controller.me;

import com.entity.UserLogin;
import com.service.loginstatus.LoginStatusService;
import com.service.userlogin.UserLoginService;
import com.vo.UserLoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 目的：登录界面
 * 作用：登录
 * @author XJ
 */
@Controller
@RequestMapping("/login")
public class LoginController {
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
     * 进行登录的操作，1.管理者界面，3.用户界面
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
                    modelAndView.setViewName("be/admin");
                }break;
                case 3:{
                    modelAndView.setViewName("fe/user");
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
