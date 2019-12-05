package com.service.loginstatus;

/**
 * @author XJ
 */
public interface LoginStatusService {
    /**
     * 查询用户的身份
     * @param loginId 用户的登录ID
     * @return
     */
    int getId(String loginId);
}
