package com.service.video;

import com.entity.Video;

/**
 * @author XJ
 */
public interface VideoService {
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
