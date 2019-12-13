package com.controller;

import com.entrty.UserInfo;
import com.service.userinfo.UserInfoService;
import com.vo.ResponseVO;
import com.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
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

    @RequestMapping(value = "/inInfo",method = RequestMethod.GET)
    public ModelAndView inInfo(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userInfoService.infoGetById(String.valueOf(httpSession.getAttribute("Id")));
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("fe/userInfo");
        return modelAndView;
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseVO upload(String userId,MultipartFile myFile){
        String directory =
                "E:\\程序员的前半生\\程序员项目\\钰网——改变生活\\yuwang-changinglife-parent" +
                        "\\changinglife-controller\\src\\main\\resources\\static\\images\\userImages";
        //得到上传过来的文件名
        String path = directory + File.separator + userId + ".jpg";
        System.out.println("path = " + path);
        UserInfo userInfo = userInfoService.infoGetById(userId);
        System.out.println("userInfo = " + userInfo);
        userInfo.setInfoImg("/static/images/userImages/"+userId + ".jpg");
        System.out.println("userInfo = " + userInfo);
        File file = new File(path);
        try {
            myFile.transferTo(file);
            userInfoService.infoUpdate(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("e = " + e);
            return ResponseVO.newBuilder().msg("上传失败！").build();
        }
        return ResponseVO.newBuilder().msg("上传成功！").build();
    }

    @RequestMapping("/back")
    public ModelAndView back(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fe/user");
        modelAndView.addObject("userId",httpSession.getAttribute("Id"));
        return modelAndView;
    }
}
