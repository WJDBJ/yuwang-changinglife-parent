package com.service.logininfo.impl;

import com.dao.LoginIdentityDao;
import com.dao.UserInfoDao;
import com.dao.UserLoginDao;
import com.entity.LoginIdentity;
import com.entity.UserInfo;
import com.entity.UserLogin;
import com.service.logininfo.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author XJ
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {
    @Autowired(required = false)
    private UserLoginDao userLoginDao;
    @Autowired(required = false)
    private UserInfoDao userInfoDao;
    @Autowired(required = false)
    private LoginIdentityDao loginIdentityDao;
    /**
     * 注册用户的时候自动注册一个用户信息和用户身份 （注：事务）
     *
     * @param userLogin
     * @param userInfo
     */
    @Transactional
    @Override
    public void loginInfo(UserLogin userLogin, UserInfo userInfo) {
        userLoginDao.loginInsert(userLogin);
        LoginIdentity loginIdentity = new LoginIdentity();
        loginIdentity.setIdentityId(3);
        loginIdentity.setLoginId(userLogin.getLoginId());
        loginIdentityDao.identityInsert(loginIdentity);
        userInfoDao.infoInsert(userInfo);
    }
}
