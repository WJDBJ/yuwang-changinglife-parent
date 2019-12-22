package com.controller.fe;

import com.entity.UserInfo;
import com.service.userinfo.UserInfoService;
import com.vo.ResponseVO;
import com.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 目的：前端个人信息界面
 * 作用：前端个人信息的获取，头像的更换
 * @author XJ
 */
@Controller
@RequestMapping("/personalInformation")
public class PersonalInformationController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 个人信息的获取
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/inInfo",method = RequestMethod.GET)
    public ModelAndView inInfo(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userInfoService.infoGetById(String.valueOf(httpSession.getAttribute("Id")));
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("fe/userInfo");
        return modelAndView;
    }

    /**
     * 头像的更换
     * @param userId
     * @param myFile
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseVO upload(String userId, MultipartFile myFile){
        String directory = "F:\\userImages";
        //得到上传过来的文件名
        String path = directory + File.separator + userId + ".jpg";
        UserInfo userInfo = userInfoService.infoGetById(userId);
        System.out.println("userId = " + userId);
        userInfo.setInfoImg(userId + ".jpg");
        File file = new File(path);
        try {
            myFile.transferTo(file);
            userInfoService.infoUpdate(userInfo);
        } catch (IOException e) {
            return ResponseVO.newBuilder().msg("上传失败！").build();
        }
        return ResponseVO.newBuilder().msg("上传成功！").build();
    }

    /**
     * 修改个人信息
     * @param userInfoVO
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ResponseVO modify(UserInfoVO userInfoVO,HttpSession httpSession) {
        UserInfo userInfo = userInfoService.infoGetById(String.valueOf(httpSession.getAttribute("Id")));
        BeanUtils.copyProperties(userInfoVO,userInfo);
        try {
            userInfoService.infoUpdate(userInfo);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("修改失败！").build();
        }
        return ResponseVO.newBuilder().msg("修改成功！").build();
    }
}
