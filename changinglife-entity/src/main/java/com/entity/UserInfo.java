package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author XJ
 */
@Data
public class UserInfo {
    private int infoId;
    private String infoName;
    private String infoGender;
    private Date infoBirthday;
    private String infoEmail;
    private String infoAddress;
    private int infoAge;
    private String infoImg;
    private String infoDesc;
    private String loginUid;
}
