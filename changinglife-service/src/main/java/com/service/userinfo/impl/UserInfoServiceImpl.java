package com.service.userinfo.impl;

import com.dao.UserInfoDao;
import com.entity.UserInfo;
import com.service.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired(required = false)
    private UserInfoDao userInfoDao;
    /**
     * 用户修改自己的信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public int infoUpdate(UserInfo userInfo) {
        return userInfoDao.infoUpdate(userInfo);
    }

    /**
     * 展示用户信息
     *
     * @param uid
     * @return
     */
    @Override
    public UserInfo infoGetById(String uid) {
        return userInfoDao.infoGetById(uid);
    }
}
