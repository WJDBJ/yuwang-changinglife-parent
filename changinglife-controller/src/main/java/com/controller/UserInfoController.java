package com.controller;

import com.entrty.UserInfo;
import com.service.userinfo.UserInfoService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XJ
 */
@Controller
//@RequestMapping("/info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/getName")
    @ResponseBody
    public ResponseVO getName(String name){
        UserInfo userInfo = userInfoService.infoGetById(name);
        System.out.println(name);
        if(userInfo.getInfoName() != null) {
            return ResponseVO.newBuilder().msg("欢迎登录"+userInfo.getInfoName()).code("200").data(userInfo).build();
        }else {
            return ResponseVO.newBuilder().msg("获取信息失败").code("500").build();
        }
    }
}
