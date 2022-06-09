package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping(value = "/member/register")
    MemberResponseDto registerToMember(@RequestBody MemberRequestDto memberRequestDto) {
        return memberService.registerToMember(memberRequestDto);
    }
}
