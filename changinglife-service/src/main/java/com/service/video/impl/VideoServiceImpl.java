package com.service.video.impl;

import com.dao.VideoDao;
import com.entity.Video;
import com.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired(required = false)
    private VideoDao videoDao;

    @Override
    public int auditFailure(String videoId) {
        return videoDao.auditFailure(videoId);
    }

    @Override
    public int goAudit(String videoId) {
        return videoDao.goAudit(videoId);
    }

    @Override
    public int videoCountId(String videoId) {
        return videoDao.videoCountId(videoId);
    }

    @Override
    public int insertVideo(Video video) {
        return videoDao.insertVideo(video);
    }

    @Override
    public List<Video> getAll(int pageNum, int pageSize) {
        return videoDao.getAll(pageNum, pageSize);
    }

    @Override
    public List<Video> getAuditAll(int pageNum, int pageSize) {
        return videoDao.getAuditAll(pageNum, pageSize);
    }
}
