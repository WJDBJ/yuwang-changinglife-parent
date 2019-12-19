package com.entity;

import lombok.Data;

/**
 * @author XJ
 */
@Data
public class LoginIdentity {
    private String loginId;
    private String loginAccoun;
    private String loginPassword;
    private int identityId;
    private String identityName;
}
