package com.service.videotypes;

/**
 * @author XJ
 */
public interface VideoTypesService {
    /**
     * 添加类型和视频关联
     * @param videoId
     * @param typeId
     * @return
     */
    int vtInsert(String videoId,String...typeId);

    /**
     * 删除关联
     * @param videoId
     * @return
     */
    int vtDelete(String videoId);
}
