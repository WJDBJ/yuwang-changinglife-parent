package com.service.status.impl;

import com.dao.StatusDao;
import com.entity.Status;
import com.service.status.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XJ
 */
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired(required = false)
    private StatusDao statusDao;

    @Override
    public int insert(Status status) {
        return statusDao.insert(status);
    }

    @Override
    public int delete(int statusId) {
        return statusDao.delete(statusId);
    }

    @Override
    public int getCount(String statusName) {
        return statusDao.getCount(statusName);
    }

    @Override
    public List<Status> getAll(int pageNum, int pageSize) {
        return statusDao.getAll(pageNum,pageSize);
    }
}
