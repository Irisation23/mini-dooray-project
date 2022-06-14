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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskNo;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_date")
    private LocalDate taskDate;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "task_writer")
    private String taskWriter;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;

    @OneToOne
    @JoinColumn(name = "milestone_no")
    private MileStone milestone;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Tag> tagList;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Comment> commentList;
}
