package com.nhnacademy.minidoorayclient.controller;

import com.nhnacademy.minidoorayclient.dto.member.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclient.dto.project.request.ProjectRequestDto;
import com.nhnacademy.minidoorayclient.service.ProjectService;
import com.nhnacademy.minidoorayclient.vo.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @ModelAttribute(value = "member")
    public SecurityUser getSecurityUser(HttpServletRequest request) throws IllegalAccessException {

        if (request.getSession() == null) {
            throw new IllegalAccessException();
        }

        HttpSession session = request.getSession(false);
        return (SecurityUser) session.getAttribute("member");
    }

    @GetMapping(value = "/project/register")
    public ModelAndView projectRegister() {
        return new ModelAndView("project-form");
    }

    @PostMapping(value = "/project/register")
    public ModelAndView doProjectRegister(@Validated ProjectRequestDto projectRequestDto, @ModelAttribute("member") SecurityUser member) {

        String successMessage = projectService.registerProject(projectRequestDto, member.getMemberId());
        ModelAndView modelAndView = new ModelAndView("/project-register-success");
        modelAndView.addObject("message", successMessage);
        return modelAndView;
    }

    @GetMapping(value = "/project/{projectNo}")
    public ModelAndView projectReadToProjectNo(@PathVariable(name = "projectNo") Long projectNo) {

        ModelAndView modelAndView = new ModelAndView("project-read");
        ProjectResponseDto projectResponseDto = projectService.projectReadToProjectNo(projectNo);
        modelAndView.addObject("project", projectResponseDto);
        return modelAndView;
    }


}
