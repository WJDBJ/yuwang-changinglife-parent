package com.controller;

import com.entrty.UserInfo;
import com.entrty.UserLogin;
import com.entrty.UserStatus;
import com.service.logininfo.LoginInfoService;
import com.service.userlogin.UserLoginService;
import com.service.userstatus.UserStatusService;
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
    @Autowired
    private UserStatusService userStatusService;

    /**
     * 注册界面
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "me/register";
    }

    /**
     *注册
     * @param userLoginVO 注册的内容
     * @return
     */
    @RequestMapping("/inRegister")
    public ModelAndView inRegister(UserLoginVO userLoginVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Login",userLoginVO);
        //得到一个唯一的用户ID
        String filename;
        while(true) {
            filename = RandomStringUtils.randomAlphanumeric(11);
            if(userLoginService.loginCountId(filename) == 0) {
                break;
            }
        }
        System.out.println("filename = " + filename);
        userLoginVO.setLoginId(filename);
        //获得UserLogin的对象
        UserLogin userLogin = (UserLogin) copy(userLoginVO,UserLogin.class);
        UserInfo userInfo = (UserInfo) copy
                (UserInfoVO.newBuilder().infoName(userLoginVO.getLoginName()).
                        infoImg("/static/images/1.png").infoDesc("用户没有什么要说的")
                        .loginUid(filename).build(),UserInfo.class);
        try {
            //用事务尝试添加用户和用户信息
            loginInfoService.loginInfo(userLogin,userInfo);
        }catch (Exception e) {
            modelAndView.setViewName("me/register");
            return modelAndView;
        }
        //添加用户后给用户添加权限
        UserStatus userStatus = new UserStatus();
        userStatus.setStatusIds(3);
        userStatus.setUserIds(filename);
        userStatusService.insert(userStatus);
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
