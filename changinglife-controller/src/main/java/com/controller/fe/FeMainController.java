package com.controller.fe;

import com.entity.UserInfo;
import com.service.userinfo.UserInfoService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 目的：前端主界面
 * 作用：前端个人信息简略信息和各个模块的连接
 * @author XJ
 */
@Controller
@RequestMapping("/feMain")
public class FeMainController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 获取用户名和图片用于展示在主界面
     * @param name
     * @return
     */
    @RequestMapping("/getName")
    @ResponseBody
    public ResponseVO getName(String name, HttpSession httpSession){
        UserInfo userInfo = userInfoService.infoGetById(name);
        httpSession.setAttribute("Id",name);
        if(userInfo.getInfoName() != null) {
            return ResponseVO.newBuilder().msg("欢迎登录"+userInfo.getInfoName()).code("200").data(userInfo).build();
        }else {
            return ResponseVO.newBuilder().msg("获取信息失败").code("500").build();
        }
    }

    /**
     * 前台的返回主界面
     * @param httpSession
     * @return
     */
    @RequestMapping("/back")
    public ModelAndView back(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fe/user");
        modelAndView.addObject("userId",httpSession.getAttribute("Id"));
        return modelAndView;
    }
}
