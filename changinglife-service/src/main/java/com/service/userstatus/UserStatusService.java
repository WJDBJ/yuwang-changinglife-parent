package com.service.userstatus;

import com.entrty.UserStatus;

/**
 * @author XJ
 */
public interface UserStatusService {
    /**
     * 添加用户时候绑定用户权限
     * @param userStatus
     * @return
     */
    int insert(UserStatus userStatus);
}
