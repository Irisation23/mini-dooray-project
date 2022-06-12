package com.nhnacademy.minidoorayclient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@Data
public class MemberResponseDto {

    @NotBlank
    private Long memberNo;
    @NotBlank
    @Size(max = 20)
    private String memberId;
    @NotBlank
    @Size(max = 100)
    private String memberPassword;
    @NotBlank
    @Size(max = 100)
    private String memberEmail;
    @NotBlank
    @Size(max = 20)
    private String memberStatus;
    @NotBlank
    @Size(max = 10)
    private String memberAuthority;
}
