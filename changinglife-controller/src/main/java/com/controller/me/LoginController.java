package com.controller.me;

import com.entity.UserLogin;
import com.service.loginidentity.LoginIdentityService;
import com.service.loginstatus.LoginStatusService;
import com.service.userlogin.UserLoginService;
import com.util.CopyUtil;
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
    @Autowired
    private LoginIdentityService loginIdentityService;

    /**
     * 去往登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "me/userLogin";
    }

    /**
     * 进行登录的操作
     * @param userLoginVO
     * @return
     */
    @RequestMapping("/inLogin")
    public ModelAndView inLogin(UserLoginVO userLoginVO) {
        ModelAndView modelAndView = new ModelAndView();
        UserLogin userLogin = (UserLogin) CopyUtil.copy(userLoginVO,UserLogin.class);
        String userId = userLoginService.loginGetId(userLogin);
        if(userLoginService.loginGetById(userLogin) > 0) {
            modelAndView.addObject("userId",userId);
            if(loginStatusService.getId(userId)>0){
                modelAndView.setViewName("be/admin");
            } else if(loginIdentityService.getId(userId)>0){
                modelAndView.setViewName("fe/user");
            }else {
                modelAndView.setViewName("error");
            }
        } else {
            modelAndView.addObject("Login", userLoginVO);
            modelAndView.setViewName("me/userLogin");
        }
        return modelAndView;
    }
}
