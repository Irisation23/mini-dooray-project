package com.nhnacademy.minidoorayclient.controller;

import com.nhnacademy.minidoorayclient.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping(value = "/project/{projectNo}/member/{memberNo}/register")
    public ModelAndView projectMemberRegister(@PathVariable(name = "projectNo") Long projectNo
            , @PathVariable(name = "memberNo") Long memberNo) {

        ModelAndView modelAndView = new ModelAndView("project-member-register-success");
        String message = projectMemberService.registerProjectMemberToProject(projectNo,memberNo);
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
