package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.exception.NotFindMemberException;
import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

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
                , member.getMemberEmail()
                , member.getMemberStatus());
    }

    @Override
    @Transactional
    public MemberResponseDto updateToMember(MemberRequestDto memberRequestDto, Long memberNo) {

        Member member = memberRepository.findById(memberNo).orElseThrow(() ->new NotFindMemberException("해당 회원은 존재하지 않습니다."));

        Member updateMember = Member.builder()
                .memberNo(member.getMemberNo())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberEmail(member.getMemberEmail())
                .memberStatus(memberRequestDto.getMemberStatus())
                .build();

        return memberRepository.findByMemberNo(memberRepository.saveAndFlush(updateMember)
                .getMemberNo());
    }
}
