package com.nhnacademy.minidoorayclientprojectserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {

    @NotBlank
    @Size(max = 20)
    private String projectTitle;
    @Size(max = 500)
    private String projectContent;
    @NotNull
    private Long adminNo;
    @NotBlank
    @Size(max = 20)
    private String adminId;
}
