package com.nhnacademy.minidoorayclientprojectserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "comment")
@Table
public class Comment {

    @Id
    @Column(name = "comment_no")
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_date")
    private LocalDate commentDate;

    @ManyToOne
    @JoinColumn(name = "task_no")
    private Task task;
}
