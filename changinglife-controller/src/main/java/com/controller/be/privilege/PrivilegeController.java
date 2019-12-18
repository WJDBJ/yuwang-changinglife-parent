package com.controller.be.privilege;

import com.entity.Menu;
import com.entity.Status;
import com.service.menu.MenuService;
import com.service.statusmenu.StatusMenuService;
import com.service.userstatus.UserStatusService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserStatusService userStatusService;

    @Autowired
    private StatusMenuService statusMenuService;

    @RequestMapping("/query")
    @ResponseBody
    protected List<Menu> service(String id) throws ServletException, IOException {
        //通过用户id的用户身份
        Status status = userStatusService.getStatus(id);
        //通过用户身份获取该用户身份能获取到的具体权限地址
        List<Menu> menuList = statusMenuService.getPrivilege(status.getStatusId());
        return menuList;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String,Object>> list(int statusId){
        List<Map<String,Object>> jsonArray = new ArrayList<Map<String,Object>>();
        //获取全部的地址信息用于搭建树状图
        List<Menu> list = menuService.getAll();
        //通过用户身份获取该用户身份能获取到的具体权限地址，用于显示权限
        List<Menu> menuList = statusMenuService.getPrivilege(statusId);

        for(Menu p:list) {
            Map<String, Object> jsonObject = new HashMap<String, Object>();
            jsonObject.put("id", p.getMenuId());
            jsonObject.put("pId", p.getMenuPid());
            jsonObject.put("name", p.getMenuName());
            jsonObject.put("open","true");
            for(Menu r:menuList) {
                if(p.getMenuId().equals(r.getMenuId())) {
                    jsonObject.put("checked","true");
                }
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @RequestMapping("/inPrivilege")
    @ResponseBody
    public ResponseVO privilege(String[] ids,int statusId){
        List<Menu> list = new ArrayList<>();
        for (String id : ids) {
            Menu menu = new Menu();
            menu.setMenuId(id);
            list.add(menu);
        }
        try {
            statusMenuService.IDPrivilege(list, statusId);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("授权失败").build();
        }
        return ResponseVO.newBuilder().msg("授权成功").build();
    }
}
