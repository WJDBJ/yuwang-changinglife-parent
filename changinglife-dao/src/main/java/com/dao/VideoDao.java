package com.dao;

import com.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XJ
 */
public interface VideoDao {
    /**
     * 审核失败
     * @param videoId
     * @return
     */
    int auditFailure(String videoId);

    /**
     * 审核通过
     * @param videoId
     * @return
     */
    int goAudit(String videoId);

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

    /**
     * 查询全部视频信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Video> getAll(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

    /**
     * 查询全部未审核视频信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Video> getAuditAll(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
}
