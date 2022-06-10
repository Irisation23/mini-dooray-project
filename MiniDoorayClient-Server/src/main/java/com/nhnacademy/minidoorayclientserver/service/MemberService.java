package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;

public interface MemberService {
    MemberResponseDto registerToMember(MemberRequestDto memberRequestDto);

    MemberResponseDto updateToMember(MemberRequestDto memberRequestDto, Long memberNo);
}
