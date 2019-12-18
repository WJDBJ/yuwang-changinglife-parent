package com.vo;

import lombok.Data;

/**
 * @author XJ
 */
@Data
public class StatusVO {
    private int statusId;
    private String statusName;
    private String statusDescription;
    private StatusVO(){}
    private StatusVO(Builder builder) {
        setStatusId(builder.statusId);
        setStatusName(builder.statusName);
        setStatusDescription(builder.statusDescription);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int statusId;
        private String statusName;
        private String statusDescription;

        private Builder() {
        }

        public Builder statusId(int val) {
            statusId = val;
            return this;
        }

        public Builder statusName(String val) {
            statusName = val;
            return this;
        }

        public Builder statusDescription(String val) {
            statusDescription = val;
            return this;
        }

        public StatusVO build() {
            return new StatusVO(this);
        }
    }
}
