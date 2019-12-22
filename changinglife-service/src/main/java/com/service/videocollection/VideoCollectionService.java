package com.service.videocollection;

import com.entity.VideoCollection;

/**
 * @author XJ
 */
public interface VideoCollectionService {
    /**
     * 添加收藏
     * @param videoCollection
     * @return
     */
    int addCollection(VideoCollection videoCollection);

    /**
     * 避免重复收藏
     * @param videoCollection
     * @return
     */
    int collectionCount(VideoCollection videoCollection);
    /**
     * 取消收藏
     * @param videoCollection
     * @return
     */
    int deleteCollection(VideoCollection videoCollection);
}
