package com.controller.be.user;

import com.entity.LoginStatus;
import com.entity.Status;
import com.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.loginstatus.LoginStatusService;
import com.service.status.StatusService;
import com.service.userinfo.UserInfoService;
import com.service.userlogin.UserLoginService;
import com.vo.ResponseVO;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LoginStatusService loginStatusService;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private StatusService statusService;

    @RequestMapping("/inAdmin")
    public ModelAndView inAdmin(@RequestParam(value = "pageNum",
            required = false,defaultValue = "1") int pageNum, @RequestParam
                                       (value = "pageSize", required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("be/user/admins");
        List<LoginStatus> loginStatusList = loginStatusService.getAllAdmin(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(loginStatusList,3);
        modelAndView.addObject("info",pageInfo);
        return modelAndView;
    }

    @RequestMapping("/getAdmin")
    @ResponseBody
    public ResponseVO getAdmin() {
        List<Status> statusList = statusService.getAdmin();
        return ResponseVO.newBuilder().data(statusList).build();
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public ResponseVO addAdmin(LoginStatus loginStatus) {
        String filename;
        while(true) {
            filename = RandomStringUtils.randomAlphanumeric(11);
            if(userLoginService.loginCountId(filename) == 0) {
                break;
            }
        }
        loginStatus.setLoginId(filename);
        if( userLoginService.selectById(loginStatus.getLoginAccoun()) > 0 ) {
            return ResponseVO.newBuilder().msg("已有该用户").build();
        }
        try {
            loginStatusService.addLoginStatus(loginStatus);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("添加失败").build();
        }
        return ResponseVO.newBuilder().msg("添加成功").build();
    }

    @RequestMapping("/privilege")
    @ResponseBody
    public ResponseVO privilege(LoginStatus loginStatus) {
        try {
            loginStatusService.updateLoginStatus(loginStatus);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("升级权限失败").build();
        }
        return ResponseVO.newBuilder().msg("升级权限成功").build();
    }

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public ResponseVO deleteAdmin(String loginId) {
        try {
            loginStatusService.deleteLoginStatus(loginId);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("删除失败").build();
        }
        return ResponseVO.newBuilder().msg("删除成功").build();
    }
}
