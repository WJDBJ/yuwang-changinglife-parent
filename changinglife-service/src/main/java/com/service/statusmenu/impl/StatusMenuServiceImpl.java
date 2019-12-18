package com.service.statusmenu.impl;

import com.dao.StatusMenuDao;
import com.entity.Menu;
import com.entity.Status;
import com.service.status.StatusService;
import com.service.statusmenu.StatusMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class StatusMenuServiceImpl implements StatusMenuService {
    @Autowired(required = false)
    private StatusMenuDao statusMenuDao;

    @Override
    public List<Menu> getPrivilege(int statusId) {
        return statusMenuDao.getPrivilege(statusId);
    }

    @Override
    @Transactional
    public void IDPrivilege(List<Menu> list, int statusId) {
        statusMenuDao.deletePrivilege(statusId);
        statusMenuDao.insertPrivilege(statusId,list);
    }
}
