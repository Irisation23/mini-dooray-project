package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.dto.member.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclient.dto.project.request.ProjectRequestDto;

public interface ProjectService {
    String registerProject(ProjectRequestDto projectRequestDto, String memberId);

    ProjectResponseDto projectReadToProjectNo(Long projectNo);

}
