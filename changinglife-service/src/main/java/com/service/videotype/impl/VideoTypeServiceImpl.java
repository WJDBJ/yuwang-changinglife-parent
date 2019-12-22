package com.service.videotype.impl;

import com.dao.VideoTypeDao;
import com.entity.VideoType;
import com.service.videotype.VideoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class VideoTypeServiceImpl implements VideoTypeService {
    @Autowired(required = false)
    private VideoTypeDao videoTypeDao;

    @Override
    public int countId(String typeId) {
        return videoTypeDao.typeCount(typeId);
    }

    @Override
    public List<VideoType> getType() {
        return videoTypeDao.getType();
    }

    @Override
    public List<VideoType> getTypes() {
        return videoTypeDao.getTypes();
    }

    @Override
    public List<VideoType> getAll(int pageNum, int pageSize) {
        return videoTypeDao.getAll(pageNum, pageSize);
    }

    @Override
    public int insertType(VideoType videoType) {
        return videoTypeDao.insertType(videoType);
    }

    @Override
    public int deleteType(String typeId) {
        return videoTypeDao.deleteType(typeId);
    }

    @Override
    public int typeCount(String typeName) {
        return videoTypeDao.typeCount(typeName);
    }
}
