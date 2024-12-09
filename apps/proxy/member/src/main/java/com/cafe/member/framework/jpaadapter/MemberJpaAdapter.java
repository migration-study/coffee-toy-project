package com.cafe.member.framework.jpaadapter;

import com.cafe.member.application.output.MemberOutputPort;
import com.cafe.member.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberJpaAdapter implements MemberOutputPort {
    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> loadMemberByUserId(String userId) {
        return memberRepository.findMemberByUserId(userId);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
