package com.nhnacademy.minidoorayclientprojectserver.restcontroller;

import com.nhnacademy.minidoorayclientprojectserver.dto.request.ProjectRequestDto;
import com.nhnacademy.minidoorayclientprojectserver.dto.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclientprojectserver.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjectRestController {

    private final ProjectService projectService;

    @PostMapping(value = "/project/register")
    public String registerProject(@Validated @RequestBody ProjectRequestDto projectRequestDto) {
        return projectService.registerProject(projectRequestDto);
    }

    @GetMapping(value = "/project/{projectNo}")
    public ProjectResponseDto projectReadToProjectNo(@PathVariable Long projectNo) {
        return projectService.projectReadToProjectNo(projectNo);
    }
}
