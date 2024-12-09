package com.cafe.member.application.output;

import com.cafe.member.domain.model.Member;

import java.util.Optional;

public interface MemberOutputPort {
    public Optional<Member> loadMemberByUserId(String userId);

    public Member saveMember(Member member);
}
