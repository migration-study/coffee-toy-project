package com.cafe.member.framework.jpaadapter;

import com.cafe.member.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findById(Long id);

    public Optional<Member> findByUserId(String userId);

    public Member save(Member member);
}
