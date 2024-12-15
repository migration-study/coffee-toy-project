package com.cafe.member.framework.web.dto;

import com.cafe.member.domain.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberOutputDTO {
    private String userId;
    private String email;
    private String name;
    private boolean manager;

    public static MemberOutputDTO mapToDTO(Member member) {
        MemberOutputDTO memberOutputDTO = new MemberOutputDTO();
        memberOutputDTO.setUserId(member.getUserId());
        memberOutputDTO.setEmail(member.getEmail());
        memberOutputDTO.setName(member.getName());
        memberOutputDTO.setManager(member.isManager());
        return memberOutputDTO;
    }
}
