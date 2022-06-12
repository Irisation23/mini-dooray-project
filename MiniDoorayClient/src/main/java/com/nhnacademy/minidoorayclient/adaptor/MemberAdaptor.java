package com.nhnacademy.minidoorayclient.adaptor;

import com.nhnacademy.minidoorayclient.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.response.MemberResponseDto;

public interface MemberAdaptor {
    String register(MemberRequestDto memberRequestDto);

    MemberResponseDto getByMemberId(String username);

    MemberResponseDto findByMemberEmail(String email);
}
