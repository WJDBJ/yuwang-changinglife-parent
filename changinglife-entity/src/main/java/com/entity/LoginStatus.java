package com.entity;

import lombok.Data;

/**
 * @author XJ
 */
@Data
public class LoginStatus {
    private String loginId;
    private String loginAccoun;
    private String loginPassword;
    private int statusId;
    private String statusName;
    private String statusDescription;
}
