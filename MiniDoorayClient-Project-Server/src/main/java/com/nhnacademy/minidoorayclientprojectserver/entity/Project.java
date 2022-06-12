package com.nhnacademy.minidoorayclientprojectserver.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "project")
public class Project {

    @Id
    @Column(name = "project_no")
    private Long projectNo;

    @Column(name = "project_title")
    private String projectTitle;

    @Column(name = "project_content")
    private String projectContent;

    @Column(name = "project_status")
    private String projectStatus;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    @NotEmpty
    private List<ProjectMember> projectMemberList;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> taskList;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<MileStone> mileStoneList;

}

