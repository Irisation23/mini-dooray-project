package com.nhnacademy.minidoorayclientprojectserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "tag")
public class Tag {

    @Id
    @Column(name = "tag_no")
    private Long tagNo;

    @Column(name = "tag_title")
    private String tagTitle;

    @ManyToOne
    @JoinColumn(name = "task_no")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;
}


/**
 *
 * TODO :
 * FK 는 일반 컬럼으로 만들면 안되고
 * @ManyToOne
 * @JoinColumn 을 사용해서 만들도록 한다.
 *
 * @OneToMany(MappedBy = name) 을 사용한다.
 */