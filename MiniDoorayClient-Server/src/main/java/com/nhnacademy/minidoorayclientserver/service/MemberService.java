package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberUpdateRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;

import java.util.List;

public interface MemberService {

    MemberResponseDto registerToMember(MemberRegisterRequestDto memberRegisterRequestDto);

    MemberResponseDto updateToMember(MemberUpdateRequestDto memberUpdateRequestDto, Long memberNo);

    MemberResponseDto findByMemberEmail(String email);

    MemberResponseDto getByMemberId(String memberId);

    List<MemberResponseDto> getMemberList();

    MemberResponseDto getByMemberNo(Long memberNo);
}
