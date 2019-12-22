package com.controller.fe.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/information")
public class InformationController {
    @RequestMapping("/inInformation")
    public ModelAndView inInformation(String msg){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fe/video/information");
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
}
