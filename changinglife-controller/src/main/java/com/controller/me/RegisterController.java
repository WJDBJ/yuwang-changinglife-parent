package com.controller.me;

import com.entity.UserInfo;
import com.entity.UserLogin;
import com.entity.UserStatus;
import com.service.logininfo.LoginInfoService;
import com.service.userlogin.UserLoginService;
import com.service.userstatus.UserStatusService;
import com.util.CopyUtil;
import com.vo.UserInfoVO;
import com.vo.UserLoginVO;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 目的：注册界面
 * 作用：注册
 * @author XJ
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private LoginInfoService loginInfoService;

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
        userLoginVO.setLoginId(filename);
        //获得UserLogin的对象
        UserLogin userLogin = (UserLogin) CopyUtil.copy(userLoginVO,UserLogin.class);
        UserInfo userInfo = (UserInfo) CopyUtil.copy
                (UserInfoVO.newBuilder().infoName(userLoginVO.getLoginName()).
                        infoImg("/static/images/1.png").infoDesc("用户没有什么要说的")
                        .loginUid(filename).build(),UserInfo.class);
        //用事务尝试添加用户和用户信息
        if(userLoginService.selectById(userLogin.getLoginAccoun())>0) {
            modelAndView.setViewName("me/register");
            modelAndView.addObject("msg","数据库已经有该数据,请勿重复录入");
        }else {
            try {
                loginInfoService.loginInfo(userLogin,userInfo);
                modelAndView.setViewName("me/userLogin");
            }catch (Exception e) {
                modelAndView.setViewName("me/register");
                modelAndView.addObject("msg","录入数据出现问题");
            }
        }
        return modelAndView;
    }
}
