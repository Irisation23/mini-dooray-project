package com.nhnacademy.minidoorayclient.adaptor.task;

import com.nhnacademy.minidoorayclient.dto.member.request.TaskRequestDto;

public interface TaskAdaptor {
    String registerTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto);

    String updateTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto);

    String deleteTask(Long taskNo);
}
