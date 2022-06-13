package com.nhnacademy.minidoorayclient.controller;

import com.nhnacademy.minidoorayclient.dto.member.request.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.member.response.MemberResponseDto;
import com.nhnacademy.minidoorayclient.exception.ValidationFailedException;
import com.nhnacademy.minidoorayclient.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/register")
    public ModelAndView register() {
        return new ModelAndView("member-register");
    }

    @PostMapping("/member/register")
    public ModelAndView doRegister(@Validated MemberRequestDto memberRequestDto
            , final BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        ModelAndView modelAndView = new ModelAndView("member-register-success");
        modelAndView.addObject("member",memberService.register(memberRequestDto));
        return modelAndView;
    }

    @GetMapping("/member/list")
    public ModelAndView doFindAll() {

        ModelAndView modelAndView = new ModelAndView("member-list");
        List<MemberResponseDto> memberList = memberService.findAllMember();
        modelAndView.addObject("memberList",memberList);
        return modelAndView;
    }
}
