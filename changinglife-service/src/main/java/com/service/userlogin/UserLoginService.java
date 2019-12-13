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

    /**
     * 查询有没有重复的手机号注册
     * @param accoun
     * @return
     */
    int selectById(String accoun);

    /**
     * 找出用户的ID
     * @param userLogin
     * @return
     */
    String loginGetId(UserLogin userLogin);

    /**
     * 查询有没有这个Id
     * @param Id
     * @return
     */
    int loginCountId(String Id);
}
