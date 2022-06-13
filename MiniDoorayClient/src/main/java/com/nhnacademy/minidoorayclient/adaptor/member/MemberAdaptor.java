package com.nhnacademy.minidoorayclient.adaptor.member;

import com.nhnacademy.minidoorayclient.dto.member.request.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.member.response.MemberResponseDto;

import java.util.List;

public interface MemberAdaptor {
    String register(MemberRequestDto memberRequestDto);

    MemberResponseDto getByMemberName(String username);

    MemberResponseDto findByMemberEmail(String email);

    List<MemberResponseDto> findAllMember();

    MemberResponseDto getByMemberNo(Long memberNo);
}
