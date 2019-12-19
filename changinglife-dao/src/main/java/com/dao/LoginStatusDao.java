package com.dao;

import com.entity.LoginStatus;
import com.entity.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XJ
 */
public interface LoginStatusDao {
    /**
     * 查询用户的身份
     * @param loginId 用户的登录ID
     * @return
     */
    int getId(String loginId);

    /**
     * 查询管理员
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<LoginStatus> getAllAdmin(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
}
