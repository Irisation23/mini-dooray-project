package com.nhnacademy.minidoorayclientprojectserver.service;

import com.nhnacademy.minidoorayclientprojectserver.dto.request.ProjectRequestDto;
import com.nhnacademy.minidoorayclientprojectserver.dto.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclientprojectserver.entity.Project;
import com.nhnacademy.minidoorayclientprojectserver.entity.ProjectMember;
import com.nhnacademy.minidoorayclientprojectserver.entity.status.Status;
import com.nhnacademy.minidoorayclientprojectserver.exception.NotFindProjectException;
import com.nhnacademy.minidoorayclientprojectserver.repository.ProjectMemberRepository;
import com.nhnacademy.minidoorayclientprojectserver.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    @Transactional
    public String registerProject(ProjectRequestDto projectRequestDto) {

        Project project = Project.builder()
                .adminNo(projectRequestDto.getAdminNo())
                .adminName(projectRequestDto.getAdminName())
                .projectTitle(projectRequestDto.getProjectTitle())
                .projectContent(projectRequestDto.getProjectContent())
                .projectStatus(Status.ACTIVATION)
                .build();

        Project savedProject = projectRepository.saveAndFlush(project);


        ProjectMember.ProjectMemberPk projectMemberPk =
                new ProjectMember.ProjectMemberPk(savedProject.getAdminNo(), savedProject.getProjectNo());

        ProjectMember projectMember = ProjectMember.builder()
                .projectMemberPk(projectMemberPk)
                .project(savedProject)
                .projectMemberName(savedProject.getAdminName())
                .build();

        projectMemberRepository.saveAndFlush(projectMember);

        return "프로젝트 생성 완료!!!!!";
    }

    @Override
    public ProjectResponseDto projectReadToProjectNo(Long projectNo) {

        Project project = projectRepository.findById(projectNo).orElseThrow(()
                -> new NotFindProjectException("해당 프로젝트는 존재하지 않습니다."));

        return ProjectResponseDto.builder()
                .projectNo(project.getProjectNo())
                .adminNo(project.getAdminNo())
                .adminName(project.getAdminName())
                .projectTitle(project.getProjectTitle())
                .projectContent(project.getProjectContent())
                .projectStatus(Status.ACTIVATION.toString())
                .build();
    }
}
