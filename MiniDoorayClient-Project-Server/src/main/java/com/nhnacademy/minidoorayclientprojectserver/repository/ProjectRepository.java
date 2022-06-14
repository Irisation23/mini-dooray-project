package com.nhnacademy.minidoorayclientprojectserver.repository;

import com.nhnacademy.minidoorayclientprojectserver.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
