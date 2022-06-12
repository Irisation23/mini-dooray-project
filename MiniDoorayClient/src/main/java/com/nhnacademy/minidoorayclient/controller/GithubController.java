package com.nhnacademy.minidoorayclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nhnacademy.minidoorayclient.oath2.GithubProfile;
import com.nhnacademy.minidoorayclient.oath2.OAuthToken;
import com.nhnacademy.minidoorayclient.service.MemberService;
import com.nhnacademy.minidoorayclient.service.Oauth2Service;
import com.nhnacademy.minidoorayclient.vo.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class GithubController {
    private final Oauth2Service oauth2Service;
    private final MemberService memberService;

    @GetMapping("/login/oauth2/code/github")
    public ModelAndView githubLogin(String code, HttpServletRequest request) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        OAuthToken oAuthToken = oauth2Service.getOAuthToken(code);
        GithubProfile githubProfile = oauth2Service.getGithubProfile(oAuthToken);

        SecurityUser securityUser = memberService.findByMemberEmail(githubProfile.getEmail());

        HttpSession session = request.getSession(true);

        session.setAttribute("securityUser",securityUser);

        return modelAndView;
    }


    }
