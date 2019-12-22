package com.controller.be.video;

import com.entity.Video;
import com.github.pagehelper.PageInfo;
import com.service.video.VideoService;
import com.vo.ResponseVO;
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
@RequestMapping("/videoInfo")
public class VideoInfoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/inVideoInfo")
    public ModelAndView inVideoInfo(@RequestParam(value = "pageNum", required = false,
            defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",
            required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("be/video/video");
        List<Video> videoList = videoService.getAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(videoList,3);
        modelAndView.addObject("info",pageInfo);
        return modelAndView;
    }
}
