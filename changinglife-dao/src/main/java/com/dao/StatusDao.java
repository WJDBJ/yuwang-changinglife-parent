package com.dao;

import com.entity.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XJ
 */
public interface StatusDao {
    /**
     * 添加用户身份
     * @param status
     * @return
     */
    int insert(Status status);

    /**
     * 检查有没有该身份
     * @param statusName
     * @return
     */
    int getCount(String statusName);

    /**
     * 根据身份id删除身份
     * @param statusId
     * @return
     */
    int delete(int statusId);

    /**
     * 查询身份信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Status> getAll(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    /**
     * 查询全部管理权限
     * @return
     */
    List<Status> getAdmin();
}
