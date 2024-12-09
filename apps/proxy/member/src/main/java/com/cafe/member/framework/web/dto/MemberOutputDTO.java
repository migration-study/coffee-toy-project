package com.cafe.member.framework.web.dto;

import com.cafe.member.domain.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberOutputDTO {
    private String userId;
    private String password;
    private String email;
    private String name;
    private boolean isManager;

    public static MemberOutputDTO mapToDTO(Member member) {
        MemberOutputDTO memberOutputDTO = new MemberOutputDTO();
        memberOutputDTO.setUserId(member.getUserId());
        memberOutputDTO.setPassword(member.getPassword());
        memberOutputDTO.setEmail(member.getEmail());
        memberOutputDTO.setName(member.getName());
        memberOutputDTO.setManager(member.isManager());
        return memberOutputDTO;
    }
}
