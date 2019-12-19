package com.service.loginidentity.impl;

import com.dao.LoginIdentityDao;
import com.service.loginidentity.LoginIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class LoginIdentityServiceImpl implements LoginIdentityService {
    @Autowired(required = false)
    private LoginIdentityDao loginIdentityDao;

    @Override
    public int getId(String loginId) {
        return loginIdentityDao.getId(loginId);
    }
}
