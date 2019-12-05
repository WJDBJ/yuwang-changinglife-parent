package com.controller;

import com.entrty.UserInfo;
import com.entrty.UserLogin;
import com.service.logininfo.LoginInfoService;
import com.service.userinfo.UserInfoService;
import com.service.userlogin.UserLoginService;
import com.vo.UserInfoVO;
import com.vo.UserLoginVO;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/loginInfo")
public class LoginInfoController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private LoginInfoService loginInfoService;

    @RequestMapping("/register")
    public String register() {
        return "me/register";
    }

    @RequestMapping("/inRegister")
    public ModelAndView inRegister(UserLoginVO userLoginVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Login",userLoginVO);
        String filename;
        while(true) {
            filename = RandomStringUtils.randomAlphanumeric(11);
            if(userLoginService.loginCountId(filename) == 0) {
                break;
            }
        }
        System.out.println("filename = " + filename);
        userLoginVO.setLoginId(filename);
        UserLogin userLogin = (UserLogin) copy(userLoginVO,UserLogin.class);
        UserInfo userInfo = (UserInfo) copy
                (UserInfoVO.newBuilder().infoDesc("用户没有什么要说的").loginUid(filename).build(),UserInfo.class);
        try {
            loginInfoService.loginInfo(userLogin,userInfo);
        }catch (Exception e) {
            modelAndView.setViewName("me/register");
        }
        modelAndView.setViewName("me/userLogin");
        return modelAndView;
    }

    public Object copy(Object object,Class<?> clz) {
        Object result = null;
        try {
            result = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(object,result);
        return result;
    }
}
