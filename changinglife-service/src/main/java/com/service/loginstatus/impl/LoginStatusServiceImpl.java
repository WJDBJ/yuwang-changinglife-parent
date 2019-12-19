package com.service.loginstatus.impl;

import com.dao.LoginStatusDao;
import com.entity.LoginStatus;
import com.service.loginstatus.LoginStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class LoginStatusServiceImpl implements LoginStatusService {
    @Autowired(required = false)
    private LoginStatusDao loginStatusDao;

    @Override
    public int getId(String loginId) {
        return loginStatusDao.getId(loginId);
    }

    @Override
    public List<LoginStatus> getAllAdmin(int pageNum, int pageSize) {
        return loginStatusDao.getAllAdmin(pageNum, pageSize);
    }
}
