package com.service.video.impl;

import com.dao.VideoDao;
import com.entity.Video;
import com.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired(required = false)
    private VideoDao videoDao;
    @Override
    public int videoCountId(String videoId) {
        return videoDao.videoCountId(videoId);
    }

    @Override
    public int insertVideo(Video video) {
        return videoDao.insertVideo(video);
    }
}
