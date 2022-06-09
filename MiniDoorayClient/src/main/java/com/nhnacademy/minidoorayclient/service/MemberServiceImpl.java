package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.adaptor.MemberAdaptor;
import com.nhnacademy.minidoorayclient.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberAdaptor memberAdaptor;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(MemberRequestDto memberRequestDto) {
        MemberRequestDto encodingMemberRequestDto = MemberRequestDto.builder()
                .memberId(memberRequestDto.getMemberId())
                .memberPassword(passwordEncoder.encode(memberRequestDto.getMemberPassword()))
                .memberEmail(memberRequestDto.getMemberEmail())
                .build();

        memberAdaptor.register(encodingMemberRequestDto);

        return memberAdaptor.register(encodingMemberRequestDto);

    }
}
