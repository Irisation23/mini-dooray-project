package com.nhnacademy.minidoorayclientprojectserver.repository;

import com.nhnacademy.minidoorayclientprojectserver.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.ProjectMemberPk> {

}
