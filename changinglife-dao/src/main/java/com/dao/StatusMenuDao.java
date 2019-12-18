package com.dao;

import com.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XJ
 */
public interface StatusMenuDao {
    /**
     * 通过用户权限获取该用户权限能获取到的具体权限地址
     * @param statusId
     * @return
     */
    List<Menu> getPrivilege(int statusId);

    /**
     * 根据身份id删除该身份的所有地址权限
     * @param statusId
     * @return
     */
    int deletePrivilege(int statusId);

    /**
     * 根据身份id和授权的地址id添加权限
     * @param privileges
     * @param statusId
     * @return
     */
    int insertPrivilege( @Param("statusId") int statusId,@Param("privileges") List<Menu> privileges);
}
