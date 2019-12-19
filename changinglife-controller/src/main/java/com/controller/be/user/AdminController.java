package com.controller.be.user;

import com.entity.LoginStatus;
import com.entity.Status;
import com.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.loginstatus.LoginStatusService;
import com.service.status.StatusService;
import com.service.userinfo.UserInfoService;
import com.vo.ResponseVO;
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
}
