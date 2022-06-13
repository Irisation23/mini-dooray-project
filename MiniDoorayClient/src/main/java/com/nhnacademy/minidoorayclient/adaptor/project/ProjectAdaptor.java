package com.nhnacademy.minidoorayclient.adaptor.project;

import com.nhnacademy.minidoorayclient.dto.member.request.TaskRequestDto;
import com.nhnacademy.minidoorayclient.dto.member.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclient.dto.project.request.ProjectRequestDto;

public interface ProjectAdaptor {
    String registerProject(ProjectRequestDto projectRequestDto);

    ProjectResponseDto projectReadToProjectNo(Long projectNo);

}
