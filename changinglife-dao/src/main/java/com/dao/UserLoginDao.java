package com.dao;

import com.entity.UserLogin;

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
     * 找出用户的ID
     * @param userLogin
     * @return
     */
    String loginGetId(UserLogin userLogin);

    /**
     * 注册账号密码的地方
     * @param userLogin 用户需要注册的账号密码 （注：该方法将和信息注册一起进行）
     * @return
     */
    int loginInsert(UserLogin userLogin);

    /**
     * 查询有没有重复的手机号注册
     * @param accoun
     * @return
     */
    int selectById(String accoun);

    /**
     * 查询有没有这个Id
     * @param Id
     * @return
     */
    int loginCountId(String Id);
}
