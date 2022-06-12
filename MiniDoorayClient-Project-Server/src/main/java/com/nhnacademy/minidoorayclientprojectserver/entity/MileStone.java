package com.nhnacademy.minidoorayclientprojectserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "milestone")
@Table
public class MileStone {

    @Id
    @Column(name = "milestone_no")
    private Long milestoneNo;

    @Column(name = "project_no")
    private Long projectNo;

    @Column(name = "milestone_status")
    private String milestoneStatus;

    @Column(name = "milestone_title")
    private String milestoneTitle;

    @Column(name = "milestone_end_date")
    private String milestoneEndDate;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;

    @OneToOne(mappedBy = "milestone")
    private Task task;
}
