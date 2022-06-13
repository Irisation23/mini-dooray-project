package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.adaptor.member.MemberAdaptor;
import com.nhnacademy.minidoorayclient.dto.member.request.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.member.response.MemberResponseDto;
import com.nhnacademy.minidoorayclient.vo.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        return memberAdaptor.register(encodingMemberRequestDto);
    }

    @Override
    public SecurityUser findByMemberEmail(String email) {

        MemberResponseDto responseDto = memberAdaptor.findByMemberEmail(email);

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(responseDto.getMemberAuthority());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        SecurityUser securityUser = SecurityUser.builder()
                .memberNo(responseDto.getMemberNo())
                .memberId(responseDto.getMemberId())
                .memberPassword(responseDto.getMemberPassword())
                .memberEmail(responseDto.getMemberEmail())
                .memberStatus(responseDto.getMemberStatus())
                .build();

        Authentication authentication = new UsernamePasswordAuthenticationToken(securityUser.getUsername()
                , securityUser.getPassword()
                , authorities);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        return securityUser;
    }

    @Override
    public List<MemberResponseDto> findAllMember() {
        return memberAdaptor.findAllMember();
    }
}

/*
# 로컬 저장소에서 원격 저장소 올리는 단계
1. git add     (unstaged -> staged)
2. git commit  (add 한 파일들만 커밋함)
3. git push    (commit 한 것만 깃헙에 올라감)
 */