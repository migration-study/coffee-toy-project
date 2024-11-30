package com.example;

import com.example.dto.member.request.MemberSignUpRequest;
import org.springframework.stereotype.Service;
import com.example.dto.member.request.MemberFindRequest;

@Service
public class MemberService {

    /**
     * 멤버 조회
     */
    public void findMember(MemberFindRequest request) {
        System.out.println(request);
    }

    /**
     * 모든 멤버 조회
     */
    public void findAllMember() {
    }

    /**
     * 회원 가입
     */
    public void signUp(MemberSignUpRequest request) {
        System.out.println(request);
    }
}
