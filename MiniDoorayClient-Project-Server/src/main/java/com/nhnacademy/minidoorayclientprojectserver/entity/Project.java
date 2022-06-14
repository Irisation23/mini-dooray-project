package com.nhnacademy.minidoorayclientprojectserver.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhnacademy.minidoorayclientprojectserver.entity.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Long projectNo;

    @Column(name = "admin_no")
    private Long adminNo;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "project_title")
    private String projectTitle;

    @Column(name = "project_content")
    private String projectContent;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private Status projectStatus;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<ProjectMember> projectMemberList;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> taskList;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<MileStone> mileStoneList;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Tag> tagList;
}

