package com.service.menu;

import com.entity.Menu;

import java.util.List;

/**
 * @author XJ
 */
public interface MenuService {
    /**
     * 查询全部的地址
     * @return
     */
    List<Menu> getAll();
}
