package com.cafe.member.application.input;

import com.cafe.member.application.output.MemberOutputPort;
import com.cafe.member.application.usecase.AddMemberUsecase;
import com.cafe.member.domain.model.Member;
import com.cafe.member.framework.web.dto.MemberInfoDTO;
import com.cafe.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddMemberInputPort implements AddMemberUsecase {
    private final MemberOutputPort memberOutputPort;

    @Override
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO) {
        Optional<Member> loadMember = memberOutputPort.loadMemberByUserId(memberInfoDTO.getUserId());

        if (loadMember.isPresent()) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        Member addMember = Member.createMember(memberInfoDTO.getUserId()
                                            , memberInfoDTO.getPassword()
                                            , memberInfoDTO.getEmail()
                                            , memberInfoDTO.getName()
                                            , memberInfoDTO.isManager());

        Member saveMember = memberOutputPort.saveMember(addMember);

        return MemberOutputDTO.mapToDTO(saveMember);
    }
}
