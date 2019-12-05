package com.dao;

/**
 * @author XJ
 */
public interface LoginStatusDao {
    /**
     * 查询用户的身份
     * @param loginId 用户的登录ID
     * @return
     */
    int getId(String loginId);
}
