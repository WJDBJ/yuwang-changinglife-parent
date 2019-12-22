package com.service.videotype;

import com.entity.VideoType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XJ
 */
public interface VideoTypeService {
    /**
     * 查询是否id重复
     * @param typeId
     * @return
     */
    int countId(String typeId);

    /**
     * 获取全部类型
     * @return
     */
    List<VideoType> getType();

    /**
     * 获取全部类型
     * @return
     */
    List<VideoType> getTypes();

    /**
     * 查询全部视频类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<VideoType> getAll(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

    /***
     * 添加视频类型
     * @param videoType
     * @return
     */
    int insertType(VideoType videoType);

    /**
     * 根据Id删除视频类型
     * @param typeId
     * @return
     */
    int deleteType(String typeId);

    /**
     * 查询类型是否重复
     * @param typeName
     * @return
     */
    int typeCount(String typeName);
}
