package com.cafe.member.application.usecase;

import com.cafe.member.framework.web.dto.MemberInfoDTO;
import com.cafe.member.framework.web.dto.MemberOutputDTO;

public interface AddMemberUsecase {
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO);
}
