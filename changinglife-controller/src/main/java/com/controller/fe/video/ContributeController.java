package com.controller.fe.video;

import com.service.loginidentity.LoginIdentityService;
import com.vo.ResponseVO;
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

/**
 * @author XJ
 */
@Controller
@RequestMapping("/contribute")
public class ContributeController {

    @Autowired
    private LoginIdentityService loginIdentityService;

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
        if(loginIdentityService.getIdentity(loginId)==0) {
            return ResponseVO.newBuilder().code("500").data("/video/inVideo").build();
        }else {
            return ResponseVO.newBuilder().code("200").data("/contribute/contribute").build();
        }
    }

    @PostMapping("/upload")
    public String upload(String filename,MultipartFile myFile){
        String directory =
                "E:\\程序员的前半生\\程序员项目\\钰网——改变生活\\yuwang-changinglife-parent" +
                        "\\changinglife-controller\\src\\main\\resources\\static\\video";
        //得到上传过来的文件名
        String[] s = myFile.getOriginalFilename().split(".");
        String path = directory + File.separator + filename +"."+ s[1];
        File file = new File(path);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return "forward:/video/inVideo";
        }
    }

}
