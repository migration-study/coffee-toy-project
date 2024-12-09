package com.cafe.member.framework.web;

import com.cafe.member.application.usecase.AddMemberUsecase;
import com.cafe.member.framework.web.dto.MemberInfoDTO;
import com.cafe.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final AddMemberUsecase addMemberUsecase;

    @PostMapping("/join/")
    public ResponseEntity<MemberOutputDTO> joinMember(@RequestBody MemberInfoDTO memberInfoDTO) {
        MemberOutputDTO addedMember = addMemberUsecase.addMember(memberInfoDTO);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }
}
