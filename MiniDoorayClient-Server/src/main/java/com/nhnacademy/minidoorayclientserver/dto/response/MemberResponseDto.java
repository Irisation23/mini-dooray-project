package com.nhnacademy.minidoorayclientserver.dto.response;

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
public class MemberResponseDto {

    @NotBlank
    @Size(max = 20)
    private String memberId;
    @NotBlank
    @Size(max = 20)
    private String memberEmail;
    @NotBlank
    @Size(max = 5)
    private String memberStatus;
}
