package com.nhnacademy.minidoorayclient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberResponseDto {
    // TODO: 검증 해야함
    private String memberEmail;
    private String memberId;
}
