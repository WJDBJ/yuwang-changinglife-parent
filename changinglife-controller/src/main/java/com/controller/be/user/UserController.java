package com.controller.be.user;

import com.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/inUser")
    public ModelAndView inUser(@RequestParam(value = "pageNum",
            required = false,defaultValue = "1") int pageNum, @RequestParam
            (value = "pageSize", required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("be/user/user");
        List<UserInfo> infoList = userInfoService.getAllUser(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(infoList,3);
        modelAndView.addObject("info",pageInfo);
        return modelAndView;
    }
}
