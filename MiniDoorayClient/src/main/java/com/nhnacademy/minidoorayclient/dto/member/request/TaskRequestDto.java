package com.nhnacademy.minidoorayclient.dto.member.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskRequestDto {

    private String taskTitle;
    private String taskContent;
    private String taskWriter;
}
