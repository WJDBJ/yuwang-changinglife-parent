package com.service.statusmenu;

import com.entity.Menu;

import java.util.List;

/**
 * @author XJ
 */
public interface StatusMenuService {
    /**
     * 通过用户权限获取该用户权限能获取到的具体权限地址
     * @param statusId
     * @return
     */
    List<Menu> getPrivilege(int statusId);

    /**
     * 授权
     * @param list
     * @param statusId
     * @return
     */
    void IDPrivilege(List<Menu> list,int statusId);
}
