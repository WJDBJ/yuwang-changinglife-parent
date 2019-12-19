package com.service.loginstatus.impl;

import com.dao.LoginStatusDao;
import com.dao.UserLoginDao;
import com.entity.LoginStatus;
import com.entity.UserLogin;
import com.service.loginstatus.LoginStatusService;
import com.service.userlogin.UserLoginService;
import com.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class LoginStatusServiceImpl implements LoginStatusService {
    @Autowired(required = false)
    private LoginStatusDao loginStatusDao;
    @Autowired(required = false)
    private UserLoginDao userLoginDao;

    @Override
    public int getId(String loginId) {
        return loginStatusDao.getId(loginId);
    }

    @Override
    @Transactional
    public void addLoginStatus(LoginStatus loginStatus) {
        UserLogin userLogin = (UserLogin) CopyUtil.copy(loginStatus,UserLogin.class);
        userLoginDao.loginInsert(userLogin);
        loginStatusDao.addLoginStatus(loginStatus);
    }

    @Override
    @Transactional
    public void deleteLoginStatus(String loginId) {
        loginStatusDao.deleteLoginStatus(loginId);
        userLoginDao.deleteLogin(loginId);
    }

    @Override
    public int updateLoginStatus(LoginStatus loginStatus) {
        return loginStatusDao.updateLoginStatus(loginStatus);
    }

    @Override
    public List<LoginStatus> getAllAdmin(int pageNum, int pageSize) {
        return loginStatusDao.getAllAdmin(pageNum, pageSize);
    }
}
