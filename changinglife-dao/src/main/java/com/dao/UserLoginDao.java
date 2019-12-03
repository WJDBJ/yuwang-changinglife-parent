package com.dao;

import com.entrty.UserLogin;

/**
 * @author XJ
 */
public interface UserLoginDao {
    /**
     * 用户登录验证数据库
     * @param userLogin 传入用户的账号密码
     * @return
     */
    int loginGetById(UserLogin userLogin);

    /**
     * 注册账号密码的地方
     * @param userLogin 用户需要注册的账号密码 （注：该方法将和信息注册一起进行）
     * @return
     */
    int loginInsert(UserLogin userLogin);

}
