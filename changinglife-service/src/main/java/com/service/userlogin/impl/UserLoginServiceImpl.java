package com.service.userlogin.impl;

import com.dao.UserLoginDao;
import com.entrty.UserLogin;
import com.service.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginDao userLoginDao;
    /**
     * 用户登录验证数据库
     *
     * @param userLogin 传入用户的账号密码
     * @return
     */
    @Override
    public int loginGetById(UserLogin userLogin) {
        return userLoginDao.loginGetById(userLogin);
    }
}
