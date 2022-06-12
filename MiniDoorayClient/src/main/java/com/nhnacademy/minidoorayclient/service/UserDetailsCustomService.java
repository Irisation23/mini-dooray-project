package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.adaptor.MemberAdaptor;
import com.nhnacademy.minidoorayclient.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclient.vo.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsCustomService implements UserDetailsService {
    private final MemberAdaptor memberAdaptor;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberResponseDto memberResponseDto = memberAdaptor.getByMemberId(username);

        // TODO : 권한을 가져와야함.
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(memberResponseDto.getMemberAuthority());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return SecurityUser.builder()
                .memberNo(memberResponseDto.getMemberNo())
                .memberId(memberResponseDto.getMemberId())
                .memberPassword(memberResponseDto.getMemberPassword())
                .memberEmail(memberResponseDto.getMemberEmail())
                .memberStatus(memberResponseDto.getMemberStatus())
                .authorities(authorities)
                .build();
    }
}
