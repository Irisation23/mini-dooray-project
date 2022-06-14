package com.nhnacademy.minidoorayclientprojectserver.service;

import com.nhnacademy.minidoorayclientprojectserver.entity.Project;
import com.nhnacademy.minidoorayclientprojectserver.entity.ProjectMember;
import com.nhnacademy.minidoorayclientprojectserver.exception.NotFindProjectException;
import com.nhnacademy.minidoorayclientprojectserver.exception.NotFindProjectMemberException;
import com.nhnacademy.minidoorayclientprojectserver.repository.ProjectMemberRepository;
import com.nhnacademy.minidoorayclientprojectserver.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;

    @Override
    @Transactional
    public String registerProjectMemberToProject(Long projectNo, Long memberNo) {

        Project project = projectRepository.findById(projectNo)
                .orElseThrow(() -> new NotFindProjectException("해당 프로젝트는 존재하지 않습니다."));

        ProjectMember.ProjectMemberPk projectMemberPk =
                new ProjectMember.ProjectMemberPk(memberNo, project.getProjectNo());

        // TODO : #1 프로젝트 멤버가 받아와야 할 이름 setting 작업 필요!
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberPk)
                .orElseThrow(() -> new NotFindProjectMemberException("해당 프로젝트 멤버는 존재하지 않습니다."));

        projectMemberRepository.saveAndFlush(projectMember);

        return "프로젝트 멤버 생성 완료.";
    }
}
