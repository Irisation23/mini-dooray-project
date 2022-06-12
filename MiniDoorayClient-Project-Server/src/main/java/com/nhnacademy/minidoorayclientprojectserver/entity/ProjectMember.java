package com.nhnacademy.minidoorayclientprojectserver.entity;

import com.nhnacademy.minidoorayclientprojectserver.entity.authority.Authority;
import com.nhnacademy.minidoorayclientprojectserver.entity.status.Status;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "project_member")
public class ProjectMember {

    @NotNull
    @EmbeddedId
    private ProjectMemberPk projectMemberPK;

    @Enumerated
    @Column(name = "project_member_authority")
    private Authority authority;

    @MapsId("projectMemberNo")
    @ManyToOne
    @JoinColumn(name = "project_no")
    @Nullable
    private Project project;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Data
    @Embeddable
    public static class ProjectMemberPk implements Serializable {

        @Column(name = "project_member_no")
        private Long projectMemberNo;

        @Column(name = "project_no")
        private Long projectNo;
    }
}
