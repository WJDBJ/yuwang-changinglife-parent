package com.dao;

import com.entity.LoginIdentity;

/**
 * @author XJ
 */
public interface LoginIdentityDao {
    /**
     * 查询用户的身份是否存在
     * @param loginId 用户的登录ID
     * @return
     */
    int getId(String loginId);

    /**
     * 查询用户的身份
     * @param loginId
     * @return
     */
    int getIdentity(String loginId);

    /**
     * 添加用户身份关联 （注册用）
     * @param loginIdentity
     * @return
     */
    int identityInsert(LoginIdentity loginIdentity);
}
