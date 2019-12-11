package com.service.userstatus.impl;

import com.entrty.UserStatus;
import com.service.userstatus.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired(required = false)
    private UserStatusService userStatusService;

    @Override
    public int insert(UserStatus userStatus) {
        return userStatusService.insert(userStatus);
    }
}
