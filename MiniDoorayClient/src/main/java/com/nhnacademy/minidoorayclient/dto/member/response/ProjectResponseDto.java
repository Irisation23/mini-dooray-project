package com.nhnacademy.minidoorayclient.dto.member.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProjectResponseDto {

    private Long projectNo;
    private Long adminNo;
    private String adminName;
    private String projectTitle;
    private String projectContent;
    private String projectStatus;
}
