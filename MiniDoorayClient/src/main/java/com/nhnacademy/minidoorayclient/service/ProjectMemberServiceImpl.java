package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.adaptor.projectmember.ProjectMemberAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService{

    private final ProjectMemberAdaptor projectMemberAdaptor;

    @Override
    public String registerProjectMemberToProject(Long projectNo, Long memberNo) {
        return projectMemberAdaptor.registerProjectMemberToProject(projectNo, memberNo);
    }
}
