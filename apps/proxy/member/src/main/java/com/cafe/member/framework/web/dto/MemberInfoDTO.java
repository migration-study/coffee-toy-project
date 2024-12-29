package com.cafe.member.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDTO {
    private String userId;
    private String password;
    private String email;
    private String name;
    private boolean manager;
}
