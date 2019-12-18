package com.service.userinfo;

import com.entity.UserInfo;

/**
 * @author XJ
 */
public interface UserInfoService {
    /**
     * 用户修改自己的信息
     * @param userInfo
     * @return
     */
    int infoUpdate(UserInfo userInfo);

    /**
     * 展示用户信息
     * @param uid
     * @return
     */
    UserInfo infoGetById(String uid);
}
