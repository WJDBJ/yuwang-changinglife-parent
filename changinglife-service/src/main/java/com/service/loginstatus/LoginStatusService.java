package com.service.loginstatus;

import com.entity.LoginStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 添加管理员用户
     * @param loginStatus
     * @return
     */
    void addLoginStatus(LoginStatus loginStatus);

    /**
     * 删除用户和用户身份
     * @param loginId
     */
    void deleteLoginStatus(String loginId);

    /**
     * 修改用户身份
     * @param loginStatus
     * @return
     */
    int updateLoginStatus(LoginStatus loginStatus);

    /**
     * 查询管理员
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<LoginStatus> getAllAdmin(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
}
