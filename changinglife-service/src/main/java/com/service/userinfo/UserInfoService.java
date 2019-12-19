package com.service.userinfo;

import com.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询全部用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UserInfo> getAllUser(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
}
