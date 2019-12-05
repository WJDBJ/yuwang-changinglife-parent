package com.service.loginstatus.impl;

import com.dao.LoginStatusDao;
import com.service.loginstatus.LoginStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class LoginStatusServiceImpl implements LoginStatusService {
    @Autowired
    private LoginStatusDao loginStatusDao;

    @Override
    public int getId(String loginId) {
        return loginStatusDao.getId(loginId);
    }
}
