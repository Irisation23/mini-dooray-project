package com.nhnacademy.minidoorayclientprojectserver.restcontroller;

import com.nhnacademy.minidoorayclientprojectserver.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectMemberRestController {
    private final ProjectMemberService projectMemberService;

    @GetMapping(value = "/project/{projectNo}/member/{memberNo}/register")
    public String registerProjectMemberToProject(@PathVariable Long projectNo
            , @PathVariable Long memberNo) {
        return projectMemberService.registerProjectMemberToProject(projectNo, memberNo);
    }
}
