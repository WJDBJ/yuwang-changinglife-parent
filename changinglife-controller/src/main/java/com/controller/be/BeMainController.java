package com.controller.be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台主界面
 * @author XJ
 */
@Controller
@RequestMapping("/beMain")
public class BeMainController {
    @RequestMapping("/admin")
    public String admin(){
        return "be/admin";
    }

    @RequestMapping("/error")
    public String error() {
        return "/error";
    }
}
