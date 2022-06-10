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
    @Size(max = 20)
    private String memberPassword;
    @NotBlank
    @Size(max = 40)
    private String memberEmail;
    @NotBlank
    @Size(max = 5)
    private String memberStatus;
}
