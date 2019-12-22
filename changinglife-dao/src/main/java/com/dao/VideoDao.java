package com.dao;

import com.entity.Video;

/**
 * @author XJ
 */
public interface VideoDao {
    /**
     * 查询视频编号
     * @param videoId
     * @return
     */
    int videoCountId(String videoId);

    /**
     * 添加视频
     * @param video
     * @return
     */
    int insertVideo(Video video);
}
