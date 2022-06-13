package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.adaptor.member.MemberAdaptor;
import com.nhnacademy.minidoorayclient.adaptor.project.ProjectAdaptor;
import com.nhnacademy.minidoorayclient.dto.member.response.MemberResponseDto;
import com.nhnacademy.minidoorayclient.dto.member.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclient.dto.project.request.ProjectRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectAdaptor projectAdaptor;
    private final MemberAdaptor memberAdaptor;

    @Override
    public String registerProject(ProjectRequestDto projectRequestDto, String memberId) {

        MemberResponseDto adminRegisterProject = memberAdaptor.getByMemberName(memberId);
        projectRequestDto.setAdminNo(adminRegisterProject.getMemberNo());
        projectRequestDto.setAdminName(adminRegisterProject.getMemberId());

        return projectAdaptor.registerProject(projectRequestDto);
    }

    @Override
    public ProjectResponseDto projectReadToProjectNo(Long projectNo) {
        return projectAdaptor.projectReadToProjectNo(projectNo);
    }
}
