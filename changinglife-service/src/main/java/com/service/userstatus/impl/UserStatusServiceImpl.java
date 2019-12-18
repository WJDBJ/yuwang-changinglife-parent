package com.service.userstatus.impl;

import com.dao.UserStatusDao;
import com.entity.Status;
import com.entity.UserStatus;
import com.service.userstatus.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired(required = false)
    private UserStatusDao userStatusDao;

    @Override
    public int insert(UserStatus userStatus) {
        return userStatusDao.insert(userStatus);
    }

    @Override
    public Status getStatus(String userId) {
        return userStatusDao.getStatus(userId);
    }
}
