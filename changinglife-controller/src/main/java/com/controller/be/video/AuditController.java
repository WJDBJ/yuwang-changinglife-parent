package com.controller.be.video;

import com.entity.Video;
import com.github.pagehelper.PageInfo;
import com.service.video.VideoService;
import com.service.videotypes.VideoTypesService;
import com.vo.ResponseVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

/**
 * @author XJ
 */
@Controller
@RequestMapping("/audit")
public class AuditController {
    @Autowired(required = false)
    RabbitTemplate template;
    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoTypesService videoTypesService;
    String FILE_DIRECTORY = "F:\\video";
    @RequestMapping("/inAudit")
    public ModelAndView inAudit(@RequestParam(value = "pageNum", required = false,
            defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",
            required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("be/video/audit");
        List<Video> videoList = videoService.getAuditAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(videoList,3);
        modelAndView.addObject("info",pageInfo);
        return modelAndView;
    }

    @RequestMapping("/auditList")
    public ModelAndView auditList(String videoId,String videoAddress){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/be/video/auditList");
        modelAndView.addObject("videoAddress",videoAddress);
        modelAndView.addObject("videoId",videoId);
        return modelAndView;
    }

    @RequestMapping("/goAudit")
    @ResponseBody
    public ResponseVO goAudits(String videoId,String typeId){
        try {
            videoTypesService.vtInsert(videoId,typeId);
            videoService.goAudit(videoId);
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("审核失败").build();
        }
        return ResponseVO.newBuilder().msg("审核成功").build();
    }

    @RequestMapping("/auditFailure")
    @ResponseBody
    public ResponseVO auditFailure(String videoId,String filename) {
        try {
            videoService.auditFailure(videoId);
            String paths = FILE_DIRECTORY + File.separator + filename;
            File file = new File(paths);
            if (file.exists()) {
                file.delete();
                System.out.println("文件已经被成功删除");
            }
        }catch (Exception e) {
            return ResponseVO.newBuilder().msg("回退视频失败").build();
        }
        return ResponseVO.newBuilder().msg("回退视频成功").build();
    }
}
