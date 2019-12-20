package com.controller.fe.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    @RequestMapping("/inVideo")
    public ModelAndView inVideo(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fe/video/video");
        modelAndView.addObject("userId",httpSession.getAttribute("Id"));
        return modelAndView;
    }
}
