package com.nhnacademy.minidoorayclientserver.service;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberUpdateRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.entity.authority.Authority;
import com.nhnacademy.minidoorayclientserver.entity.status.Status;
import com.nhnacademy.minidoorayclientserver.exception.NotFindMemberByEmailException;
import com.nhnacademy.minidoorayclientserver.exception.NotFindMemberByMemberIdException;
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
    public MemberResponseDto registerToMember(MemberRegisterRequestDto memberRegisterRequestDto) {

        Member member = new Member(memberRegisterRequestDto.getMemberId()
                , memberRegisterRequestDto.getMemberPassword()
                , memberRegisterRequestDto.getMemberEmail()
                , Status.ACTIVATION
                , Authority.ROLE_USER);

        memberRepository.saveAndFlush(member);
        return MemberResponseDto.builder()
                .memberNo(member.getMemberNo())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberEmail(member.getMemberEmail())
                .memberStatus(member.getMemberStatus().toString())
                .memberAuthority(member.getMemberAuthority().toString())
                .build();
    }

    @Override
    @Transactional
    public MemberResponseDto updateToMember(MemberUpdateRequestDto memberUpdateRequestDto, Long memberNo) {

        Member member = memberRepository.findById(memberNo)
                .orElseThrow(() ->new NotFindMemberException("해당 회원은 존재하지 않습니다."));

        Member updateMember = Member.builder()
                .memberNo(member.getMemberNo())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberEmail(member.getMemberEmail())
                .memberStatus(member.getMemberStatus())
                .memberAuthority(member.getMemberAuthority())
                .build();

        return memberRepository.findByMemberNo(memberRepository.saveAndFlush(updateMember)
                .getMemberNo());
    }

    @Override
    public MemberResponseDto findByMemberEmail(String email) {

        Member member = memberRepository.findByMemberEmail(email)
                .orElseThrow(() -> new NotFindMemberByEmailException("해당 이메 회원은 존재하지 않습니다."));

        return MemberResponseDto.builder()
                .memberNo(member.getMemberNo())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberEmail(member.getMemberEmail())
                .memberStatus(member.getMemberStatus().toString())
                .memberAuthority(member.getMemberAuthority().toString())
                .build();
    }

    @Override
    public MemberResponseDto getByMemberId(String memberId) {

        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new NotFindMemberByMemberIdException("해당 아디를 가진 회원은 존재하지 않습니다."));

        return MemberResponseDto.builder()
                .memberNo(member.getMemberNo())
                .memberId(member.getMemberId())
                .memberPassword(member.getMemberPassword())
                .memberEmail(member.getMemberEmail())
                .memberStatus(member.getMemberStatus().toString())
                .memberAuthority(member.getMemberAuthority().toString())
                .build();
    }
}
