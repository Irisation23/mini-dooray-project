package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclient.vo.SecurityUser;

public interface MemberService {
    String register(MemberRequestDto memberRequestDto);

    SecurityUser findByMemberEmail(String email);
}
