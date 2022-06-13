package com.nhnacademy.minidoorayclient.service;


import com.nhnacademy.minidoorayclient.dto.member.request.TaskRequestDto;

public interface TaskService {
    String registerTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto);

    String updateTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto);

    String deleteTask(Long taskNo);
}
