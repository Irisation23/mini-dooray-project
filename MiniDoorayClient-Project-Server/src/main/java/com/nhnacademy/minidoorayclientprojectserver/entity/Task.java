package com.nhnacademy.minidoorayclientprojectserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "task_no")
    private Long taskNo;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_date")
    private LocalDate taskDate;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;

    @OneToOne
    @JoinColumn(name = "milestone_no")
    private MileStone mileStone;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Tag> tagList;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Comment> commentList;
}
