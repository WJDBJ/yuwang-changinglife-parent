package com.service.loginidentity;

import com.entity.LoginIdentity;

/**
 * @author XJ
 */
public interface LoginIdentityService {
    /**
     * 查询用户的身份
     * @param loginId 用户的登录ID
     * @return
     */
    int getId(String loginId);
}
