package com.service.userlogin;

import com.entrty.UserLogin;

/**
 * @author XJ
 */
public interface UserLoginService {
    /**
     * 用户登录验证数据库
     * @param userLogin 传入用户的账号密码
     * @return
     */
    int loginGetById(UserLogin userLogin);
}
