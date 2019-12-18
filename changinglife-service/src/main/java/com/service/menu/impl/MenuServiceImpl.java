package com.service.menu.impl;

import com.dao.MenuDao;
import com.entity.Menu;
import com.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired(required = false)
    private MenuDao menuDao;

    @Override
    public List<Menu> getAll() {
        return menuDao.getAll();
    }
}
