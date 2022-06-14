package com.nhnacademy.minidoorayclientserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberRegisterRequestDto {

    @NotBlank
    @Size(max = 20)
    private String memberId;
    @NotBlank
    @Size(max = 100)
    private String memberPassword;
    @NotBlank
    @Size(max = 100)
    private String memberEmail;
}



