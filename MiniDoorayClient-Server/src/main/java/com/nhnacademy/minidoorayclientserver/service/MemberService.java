package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberUpdateRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;

public interface MemberService {

    MemberResponseDto registerToMember(MemberRegisterRequestDto memberRegisterRequestDto);

    MemberResponseDto updateToMember(MemberUpdateRequestDto memberUpdateRequestDto, Long memberNo);

    MemberResponseDto findByMemberEmail(String email);

    MemberResponseDto getByMemberId(String memberId);
}
