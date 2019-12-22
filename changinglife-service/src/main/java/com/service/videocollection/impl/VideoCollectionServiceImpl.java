package com.service.videocollection.impl;

import com.dao.VideoCollectionDao;
import com.entity.VideoCollection;
import com.service.videocollection.VideoCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XJ
 */
@Service
public class VideoCollectionServiceImpl implements VideoCollectionService {
    @Autowired(required = false)
    private VideoCollectionDao videoCollectionDao;
    @Override
    public int addCollection(VideoCollection videoCollection) {
        return videoCollectionDao.addCollection(videoCollection);
    }

    @Override
    public int collectionCount(VideoCollection videoCollection) {
        return videoCollectionDao.collectionCount(videoCollection);
    }

    @Override
    public int deleteCollection(VideoCollection videoCollection) {
        return videoCollectionDao.deleteCollection(videoCollection);
    }
}
