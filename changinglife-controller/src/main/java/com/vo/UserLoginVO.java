package com.vo;

import lombok.Data;

/**
 * @author XJ
 */
@Data
public class UserLoginVO {
    private String loginId;

    private String loginAccoun;
    private String loginPassword;

    private UserLoginVO(Builder builder) {
        setLoginId(builder.loginId);
        setLoginAccoun(builder.loginAccoun);
        setLoginPassword(builder.loginPassword);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String loginId;
        private String loginAccoun;
        private String loginPassword;

        private Builder() {
        }

        public Builder loginId(String val) {
            loginId = val;
            return this;
        }

        public Builder loginAccoun(String val) {
            loginAccoun = val;
            return this;
        }

        public Builder loginPassword(String val) {
            loginPassword = val;
            return this;
        }

        public UserLoginVO build() {
            return new UserLoginVO(this);
        }
    }
}
