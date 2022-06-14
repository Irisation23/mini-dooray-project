package com.nhnacademy.minidoorayclientprojectserver.service;

import com.nhnacademy.minidoorayclientprojectserver.dto.request.ProjectRequestDto;
import com.nhnacademy.minidoorayclientprojectserver.dto.request.TaskRequestDto;
import com.nhnacademy.minidoorayclientprojectserver.dto.response.ProjectResponseDto;

public interface ProjectService {

    String registerProject(ProjectRequestDto projectRequestDto);


    ProjectResponseDto projectReadToProjectNo(Long projectNo);

}
