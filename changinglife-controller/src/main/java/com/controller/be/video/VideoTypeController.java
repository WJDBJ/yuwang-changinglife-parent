package com.controller.be.video;

import com.entity.VideoType;
import com.github.pagehelper.PageInfo;
import com.service.videotype.VideoTypeService;
import com.vo.ResponseVO;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/videoType")
public class VideoTypeController {
    @Autowired
    private VideoTypeService videoTypeService;

    @RequestMapping("/inVideoType")
    public ModelAndView inVideoType(@RequestParam(value = "pageNum", required = false,
            defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",
            required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("be/video/videoType");
        List<VideoType> videoTypeList = videoTypeService.getAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(videoTypeList,3);
        modelAndView.addObject("info",pageInfo);
        return modelAndView;
    }

    @RequestMapping("/deleteType")
    @ResponseBody
    public ResponseVO deleteType(String typeId){
        try {
            videoTypeService.deleteType(typeId);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("删除失败").build();
        }
        return ResponseVO.newBuilder().msg("删除成功").build();
    }

    @RequestMapping("/insertType")
    @ResponseBody
    public ResponseVO insertType(VideoType videoType){
        if(videoTypeService.typeCount(videoType.getTypeName())>0) {
            return ResponseVO.newBuilder().msg("已经有该类型，请勿重复添加").build();
        }
        String filename;
        while(true) {
            filename = RandomStringUtils.randomAlphanumeric(11);
            if(videoTypeService.countId(filename) == 0) {
                break;
            }
        }
        videoType.setTypeId(filename);
        System.out.println("videoType = " + videoType);
        try {
            videoTypeService.insertType(videoType);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("添加失败").build();
        }
        return ResponseVO.newBuilder().msg("添加成功").build();
    }

    @RequestMapping("/getType")
    @ResponseBody
    public ResponseVO getType(){
        List<VideoType> videoTypes = videoTypeService.getType();
        return ResponseVO.newBuilder().data(videoTypes).build();
    }

    @RequestMapping("/getTypes")
    @ResponseBody
    public ResponseVO getTypes(){
        List<VideoType> videoTypes = videoTypeService.getTypes();
        return ResponseVO.newBuilder().data(videoTypes).build();
    }
}
