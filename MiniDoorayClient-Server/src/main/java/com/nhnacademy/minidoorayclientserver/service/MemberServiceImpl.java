package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponseDto registerToMember(MemberRequestDto memberRequestDto) {
        Member member = new Member(memberRequestDto.getMemberId()
                , memberRequestDto.getMemberPassword()
                , memberRequestDto.getMemberEmail()
                , memberRequestDto.getMemberStatus());

        memberRepository.saveAndFlush(member);

        return new MemberResponseDto(member.getMemberId()
                , member.getMemberEmail());
    }
}
