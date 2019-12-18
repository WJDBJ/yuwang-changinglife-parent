package com.dao;

import com.entity.Menu;

import java.util.List;

/**
 * @author XJ
 */
public interface MenuDao {
    /**
     * 查询全部的地址
     * @return
     */
    List<Menu> getAll();
}
