package com.nhnacademy.minidoorayclientserver.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class MemberRequestDto {

    // TODO : Validation 확실히 처리 해야 함.
    @NonNull
    private String memberId;
    @NonNull
    private String memberPassword;
    @NonNull
    private String memberEmail;
}
