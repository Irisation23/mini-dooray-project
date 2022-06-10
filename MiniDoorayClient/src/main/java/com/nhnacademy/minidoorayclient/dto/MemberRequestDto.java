package com.nhnacademy.minidoorayclient.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class MemberRequestDto {

   @NotBlank
   @Size(max = 20)
   private String memberId;
   @NotBlank
   @Size(max = 40)
   private String memberPassword;
   @NotBlank
   @Size(max = 40)
   private String memberEmail;
   @NotBlank
   @Size(max = 5)
   private String memberStatus;
}
