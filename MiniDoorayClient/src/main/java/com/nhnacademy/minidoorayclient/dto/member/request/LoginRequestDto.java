package com.nhnacademy.minidoorayclient.dto.member.request;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@Data
public class LoginRequestDto {

    @NotBlank
    @Size(max = 20)
    private String memberId;
    @NotBlank
    @Size(max = 60)
    private String memberPassword;
}
