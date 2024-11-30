package com.example.dto.member.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUpRequest {
    @Getter private String userId;
    @Getter private String memberId;

    @Override
    public String toString() {
        return "MemberSignUpRequest{" +
                "userId='" + userId + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
