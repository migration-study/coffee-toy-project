package com.example.member;

import com.example.dto.member.response.MemberResponse;
import graphql.GraphQL;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.member.request.MemberFindRequest;
import com.example.dto.member.request.MemberSignUpRequest;
import com.example.MemberService;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 특정 ID로 회원 조회
     */
    @QueryMapping
    public MemberResponse findMember(@Argument(name = "id") Long id) {
        MemberFindRequest request = new MemberFindRequest(id);
        memberService.findMember(request);
        return new MemberResponse(1L);
    }

    /**
     * 모든 회원 조회
     */
    @QueryMapping
    public void findMembers() {
        memberService.findAllMember();
    }

    /**
     * 회원 가입
     */
    @MutationMapping
    public void signUp(
            @Argument(name = "userId") String userId,
            @Argument(name = "password") String password
    ) {
        MemberSignUpRequest request = new MemberSignUpRequest(userId, password);
        memberService.signUp(request);
    }
}