package com.service.status;

import com.entity.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XJ
 */
public interface StatusService {
    /**
     * 添加用户身份
     * @param status
     * @return
     */
    public int insert(Status status);

    /**
     * 根据身份id删除身份
     * @param statusId
     * @return
     */
    int delete(int statusId);

    /**
     * 检查有没有该身份
     * @param statusName
     * @return
     */
    int getCount(String statusName);

    /**
     * 查询身份信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Status> getAll(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
}
