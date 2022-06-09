package com.nhnacademy.minidoorayclient.controller;

import com.nhnacademy.minidoorayclient.dto.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.MemberResponseDto;
import com.nhnacademy.minidoorayclient.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/register")
    ModelAndView register() {
        return new ModelAndView("member-register");
    }

    @PostMapping("/member/register")
    ModelAndView doRegister(@ModelAttribute MemberRequestDto memberRequestDto) {
        ModelAndView modelAndView = new ModelAndView("member-register-success");
        modelAndView.addObject("member",memberService.register(memberRequestDto));
        return modelAndView;
    }
}
