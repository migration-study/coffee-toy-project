package com.example.dto.member.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MemberFindRequest {
    @Getter
    private Long id;

    @Override
    public String toString() {
        return "MemberSampleRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
