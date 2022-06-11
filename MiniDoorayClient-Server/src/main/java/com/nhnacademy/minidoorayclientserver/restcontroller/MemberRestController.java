package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping(value = "/member/register")
    MemberResponseDto registerToMember(final @RequestBody @Validated MemberRegisterRequestDto memberRegisterRequestDto) {
        return memberService.registerToMember(memberRegisterRequestDto);
    }

    @PostMapping(value = "/member/{memberNo}/update")
    MemberResponseDto updateToMember(final @RequestBody @Validated MemberRequestDto memberRequestDto
            , @PathVariable(value = "memberNo") Long memberNo) {
        return memberService.updateToMember(memberRequestDto, memberNo);
    }
}
