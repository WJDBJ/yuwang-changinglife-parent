package com.service.logininfo.impl;

import com.dao.UserInfoDao;
import com.dao.UserLoginDao;
import com.entrty.UserInfo;
import com.entrty.UserLogin;
import com.service.logininfo.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author XJ
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {
    @Autowired
    private UserLoginDao userLoginDao;
    @Autowired
    private UserInfoDao userInfoDao;
    /**
     * 注册用户的时候自动注册一个用户信息 （注：事务）
     *
     * @param userLogin
     * @param userInfo
     */
    @Transactional
    @Override
    public void loginInfo(UserLogin userLogin, UserInfo userInfo) {
        userLoginDao.loginInsert(userLogin);
        userInfoDao.infoInsert(userInfo);
    }
}
