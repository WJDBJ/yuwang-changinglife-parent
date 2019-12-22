package com.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author XJ
 */
public interface VideoTypesDao {
    /**
     * 添加类型和视频关联
     * @param videoId
     * @param typeId
     * @return
     */
    int vtInsert(@Param("videoId")String videoId,@Param("privileges")String...typeId);

    /**
     * 删除关联
     * @param videoId
     * @return
     */
    int vtDelete(String videoId);
}
