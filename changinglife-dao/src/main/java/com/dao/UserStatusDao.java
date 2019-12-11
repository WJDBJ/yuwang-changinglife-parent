package com.dao;

import com.entrty.UserStatus;

/**
 * @author XJ
 */
public interface UserStatusDao {
    /**
     * 添加用户时候绑定用户权限
     * @param userStatus
     * @return
     */
    int insert(UserStatus userStatus);
}
