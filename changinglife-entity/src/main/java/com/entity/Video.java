package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author XJ
 */
@Data
public class Video {
    String videoId;
    String videoName;
    Date videoReleasetime;
    String videoRublisher;
    String videoIntroduction;
    String videoAddress;
    String videoAudit;
}
