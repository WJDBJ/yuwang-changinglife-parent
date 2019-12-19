package com.service.userstatus;

import com.entity.Status;
import com.entity.UserStatus;

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

    /**
     * 通过用户id来查询用户所对应的身份
     * @param userId
     * @return
     */
    Status getStatus(String userId);

    /**
     * 查询该身份有没有用户
     * @param statusId
     * @return
     */
    int getCount(int statusId);
}
