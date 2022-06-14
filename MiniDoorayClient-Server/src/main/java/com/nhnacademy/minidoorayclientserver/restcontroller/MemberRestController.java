package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberUpdateRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping(value = "/member/register")
    MemberResponseDto registerToMember(final @RequestBody @Validated MemberRegisterRequestDto memberRegisterRequestDto) {
        return memberService.registerToMember(memberRegisterRequestDto);
    }

    @PostMapping(value = "/member/{memberNo}/update")
    MemberResponseDto updateToMember(final @RequestBody @Validated MemberUpdateRequestDto memberUpdateRequestDto
            , @PathVariable(value = "memberNo") Long memberNo) {
        return memberService.updateToMember(memberUpdateRequestDto, memberNo);
    }

    @GetMapping(value = "/member")
    MemberResponseDto findByMemberEmail(@RequestParam("email") String email) {
        return memberService.findByMemberEmail(email);
    }

    @GetMapping(value = "/member/check")
    MemberResponseDto getByMemberId(@RequestParam("username") String memberId) {
        return memberService.getByMemberId(memberId);
    }

    @GetMapping(value = "/member/list")
    List<MemberResponseDto> getMemberList() {
        return memberService.getMemberList();
    }

    @GetMapping(value = "/member/read")
    MemberResponseDto getByMemberNo(@RequestParam("memberNo") Long memberNo) {
        return memberService.getByMemberNo(memberNo);
    }

}
