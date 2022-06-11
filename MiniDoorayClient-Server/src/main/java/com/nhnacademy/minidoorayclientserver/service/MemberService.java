package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;

public interface MemberService {
    MemberResponseDto registerToMember(MemberRegisterRequestDto memberRegisterRequestDto);

    MemberResponseDto updateToMember(MemberRequestDto memberRequestDto, Long memberNo);
}
