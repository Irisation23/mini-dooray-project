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

    // TODO: CUD 에 대해서 트랜잭션 처리
    @Override
    public String register(MemberRequestDto memberRequestDto) {
        MemberRequestDto encodingMemberRequestDto = MemberRequestDto.builder()
                .memberId(memberRequestDto.getMemberId())
                .memberPassword(passwordEncoder.encode(memberRequestDto.getMemberPassword()))
                .memberEmail(memberRequestDto.getMemberEmail())
                .build();

        return memberAdaptor.register(encodingMemberRequestDto);


    }
}

/*

# 로컬 저장소에서 원격 저장소 올리는 단계
1. git add     (unstaged -> staged)
2. git commit  (add 한 파일들만 커밋함)
3. git push    (commit 한 것만 깃헙에 올라감)
 */