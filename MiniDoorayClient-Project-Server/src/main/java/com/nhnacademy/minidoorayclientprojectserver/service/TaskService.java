package com.nhnacademy.minidoorayclientprojectserver.service;

import com.nhnacademy.minidoorayclientprojectserver.dto.request.TaskRequestDto;

public interface TaskService {
    String registerTask(Long projectNo, Long memberNo, TaskRequestDto projectRequestDto);

    String updateTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto);

    String deleteTask(Long taskNo);
}
