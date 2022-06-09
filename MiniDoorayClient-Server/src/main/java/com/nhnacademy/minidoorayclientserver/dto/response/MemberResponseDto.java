package com.nhnacademy.minidoorayclientserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MemberResponseDto {

    private String memberId;
    private String memberEmail;
}
