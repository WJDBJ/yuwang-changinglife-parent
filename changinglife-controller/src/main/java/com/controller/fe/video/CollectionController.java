package com.controller.fe.video;

import com.entity.VideoCollection;
import com.service.videocollection.VideoCollectionService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private VideoCollectionService videoCollectionService;

    @RequestMapping("/inCollection")
    @ResponseBody
    public ResponseVO inCollection(VideoCollection videoCollection) {
        if(videoCollectionService.collectionCount(videoCollection)>0){
            return ResponseVO.newBuilder().msg("你已经收藏了该视频").build();
        }
        try {
            videoCollectionService.addCollection(videoCollection);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("收藏失败").build();
        }
        return ResponseVO.newBuilder().msg("收藏成功").build();
    }

    @RequestMapping("/noCollection")
    @ResponseBody
    public ResponseVO noCollection(VideoCollection videoCollection) {
        if(videoCollectionService.collectionCount(videoCollection) == 0){
            return ResponseVO.newBuilder().msg("你没有收藏该视频，无法取消收藏").build();
        }
        try {
            videoCollectionService.deleteCollection(videoCollection);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("取消失败").build();
        }
        return ResponseVO.newBuilder().msg("取消成功").build();
    }
}
