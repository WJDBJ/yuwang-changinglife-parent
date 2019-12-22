package com.controller.fe.video;

import com.entity.Video;
import com.service.loginidentity.LoginIdentityService;
import com.service.video.VideoService;
import com.vo.ResponseVO;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/contribute")
public class ContributeController {

    @Autowired
    private LoginIdentityService loginIdentityService;
    @Autowired
    private VideoService videoService;


    @RequestMapping("/contribute")
    public ModelAndView contribute(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fe/video/contribute");
        modelAndView.addObject("userId",httpSession.getAttribute("Id"));
        return modelAndView;
    }

    @RequestMapping("/inContribute")
    @ResponseBody
    public ResponseVO contribute(String loginId) {
//        if(loginIdentityService.getIdentity(loginId)==0) {
//            return ResponseVO.newBuilder().code("500").msg("您还没有成为创作者，无法使用").data("/video/inVideo").build();
//        }else {
            return ResponseVO.newBuilder().code("200").msg("欢迎您，亲爱的创作者").data("/contribute/contribute").build();
//        }
    }

    @PostMapping("/upload")
    public String upload(MultipartFile myFile, Video video,HttpSession httpSession){
        //impleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String directory = "F:\\video";
        //得到上传过来的文件名
        String[] name = myFile.getOriginalFilename().split("\\.");
        String path = directory + File.separator + video.getVideoName()+"."+name[1];
        String filename;
        while(true) {
            filename = RandomStringUtils.randomAlphanumeric(11);
            if(videoService.videoCountId(filename) == 0) {
                break;
            }
        }
        video.setVideoId(filename);
        video.setVideoAddress(video.getVideoName()+"."+name[1]);
        video.setVideoAudit("N");
        video.setVideoReleasetime(date);
        video.setVideoRublisher((String) httpSession.getAttribute("Id"));
        File file = new File(path);
        try {
            myFile.transferTo(file);
            videoService.insertVideo(video);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return "forward:/video/inVideo";
        }
    }

}
