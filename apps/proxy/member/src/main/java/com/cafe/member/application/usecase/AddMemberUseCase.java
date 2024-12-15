package com.cafe.member.application.usecase;

import com.cafe.member.framework.web.dto.MemberInfoDTO;
import com.cafe.member.framework.web.dto.MemberOutputDTO;

public interface AddMemberUseCase {
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO);
}
