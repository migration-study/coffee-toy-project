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
    public Optional<Member> loadMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> loadMemberByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
