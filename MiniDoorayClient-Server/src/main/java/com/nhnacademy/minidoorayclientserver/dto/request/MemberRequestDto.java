package com.nhnacademy.minidoorayclientserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberRequestDto {

    @NotBlank
    @Size(max = 20)
    private String memberId;
    @NotBlank
    @Size(max = 100)
    private String memberPassword;
    @NotBlank
    @Size(max = 100)
    private String memberEmail;
    @NotNull
    @Size(max = 10)
    private String memberStatus;
}
