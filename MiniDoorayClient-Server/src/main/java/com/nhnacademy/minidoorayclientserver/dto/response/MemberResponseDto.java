package com.nhnacademy.minidoorayclientserver.dto.response;

import com.nhnacademy.minidoorayclientserver.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @NotNull
    @Size(max = 20)
    private String memberStatus;
    @NotNull
    @Size(max = 10)
    private String memberAuthority;

    public MemberResponseDto(Member member) {

        this.memberNo = member.getMemberNo();
        this.memberId = member.getMemberId();
        this.memberPassword = member.getMemberPassword();
        this.memberEmail = member.getMemberEmail();
        this.memberStatus = member.getMemberStatus().toString();
        this.memberAuthority = member.getMemberAuthority().toString();
    }
}
