package com.service.videotypes.impl;

import com.dao.VideoTypesDao;
import com.service.videotypes.VideoTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class VideoTypesServiceImpl implements VideoTypesService {
    @Autowired(required = false)
    private VideoTypesDao videoTypesDao;

    @Override
    public int vtInsert(String videoId, String...typeId) {
        return videoTypesDao.vtInsert(videoId, typeId);
    }

    @Override
    public int vtDelete(String videoId) {
        return videoTypesDao.vtDelete(videoId);
    }
}
