package com.controller.be.privilege;

import com.entity.Status;
import com.github.pagehelper.PageInfo;
import com.service.status.StatusService;
import com.service.userstatus.UserStatusService;
import com.util.CopyUtil;
import com.vo.ResponseVO;
import com.vo.StatusVO;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private StatusService statusService;
    @Autowired
    private UserStatusService userStatusService;

    @RequestMapping("/roleAdd")
    @ResponseBody
    public ResponseVO roleAdd(StatusVO statusVO) {
        Status status = (Status) CopyUtil.copy(statusVO,Status.class);
        if(statusService.getCount(status.getStatusName())>0) {
            return ResponseVO.newBuilder().msg("已经有该身份，请勿重复添加").build();
        }
        try {
            statusService.insert(status);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("添加失败").build();
        }
        return ResponseVO.newBuilder().msg("添加成功").build();
    }

    @RequestMapping("/inRole")
    public ModelAndView inRole(@RequestParam(value = "pageNum",
            required = false,defaultValue = "1") int pageNum, @RequestParam
            (value = "pageSize", required = false,defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("be/role/role");
        List<Status> statusList = statusService.getAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(statusList,3);
        modelAndView.addObject("status",pageInfo);
        return modelAndView;
    }

    @RequestMapping("/roleDelete")
    @ResponseBody
    public ResponseVO roleDelete(int statusId){
        if(userStatusService.getCount(statusId)>0){
            return ResponseVO.newBuilder().msg("该身份已有用户归属，无法删除").build();
        }
        try {
            statusService.delete(statusId);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("删除失败").build();
        }
        return ResponseVO.newBuilder().msg("删除成功").build();
    }
}
