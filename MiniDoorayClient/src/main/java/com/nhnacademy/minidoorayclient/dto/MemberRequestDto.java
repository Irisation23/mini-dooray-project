package com.nhnacademy.minidoorayclient.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class MemberRequestDto {

   private String memberId;
   private String memberPassword;
   private String memberEmail;
}
