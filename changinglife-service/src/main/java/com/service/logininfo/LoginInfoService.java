package com.service.logininfo;

import com.entity.UserInfo;
import com.entity.UserLogin;

/**
 * @author XJ
 */
public interface LoginInfoService {
    /**
     * 注册用户的时候自动注册一个用户信息 （注：事务）
     * @param userLogin
     * @param userInfo
     */
    void loginInfo(UserLogin userLogin, UserInfo userInfo);
}
