package com.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author XJ
 */
@Data
public class UserInfoVO {
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

    private UserInfoVO() {}

    private UserInfoVO(Builder builder) {
        setInfoId(builder.infoId);
        setInfoName(builder.infoName);
        setInfoGender(builder.infoGender);
        setInfoBirthday(builder.infoBirthday);
        setInfoEmail(builder.infoEmail);
        setInfoAddress(builder.infoAddress);
        setInfoAge(builder.infoAge);
        setInfoImg(builder.infoImg);
        setInfoDesc(builder.infoDesc);
        setLoginUid(builder.loginUid);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
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

        private Builder() {
        }

        public Builder infoId(int val) {
            infoId = val;
            return this;
        }

        public Builder infoName(String val) {
            infoName = val;
            return this;
        }

        public Builder infoGender(String val) {
            infoGender = val;
            return this;
        }

        public Builder infoBirthday(Date val) {
            infoBirthday = val;
            return this;
        }

        public Builder infoEmail(String val) {
            infoEmail = val;
            return this;
        }

        public Builder infoAddress(String val) {
            infoAddress = val;
            return this;
        }

        public Builder infoAge(int val) {
            infoAge = val;
            return this;
        }

        public Builder infoImg(String val) {
            infoImg = val;
            return this;
        }

        public Builder infoDesc(String val) {
            infoDesc = val;
            return this;
        }

        public Builder loginUid(String val) {
            loginUid = val;
            return this;
        }

        public UserInfoVO build() {
            return new UserInfoVO(this);
        }
    }
}
