package com.nhnacademy.minidoorayclient.dto.project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectRequestDto {

    @NotBlank
    @Size(max = 20)
    private String projectTitle;
    @NotBlank
    @Size(max = 500)
    private String projectContent;
    private Long adminNo;
    private String adminName;
}
