package com.nhnacademy.minidoorayclient.service;

import com.nhnacademy.minidoorayclient.adaptor.member.MemberAdaptor;
import com.nhnacademy.minidoorayclient.adaptor.task.TaskAdaptor;
import com.nhnacademy.minidoorayclient.dto.member.request.TaskRequestDto;
import com.nhnacademy.minidoorayclient.dto.member.response.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskAdaptor taskAdaptor;
    private final MemberAdaptor memberAdaptor;

    @Override
    public String registerTask (Long projectNo, Long memberNo, TaskRequestDto taskRequestDto) {
        MemberResponseDto member = memberAdaptor.getByMemberNo(memberNo);
        taskRequestDto.setTaskWriter(member.getMemberId());
        return taskAdaptor.registerTask(projectNo, memberNo, taskRequestDto);
    }

    @Override
    public String updateTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto) {
        MemberResponseDto member = memberAdaptor.getByMemberNo(memberNo);
        taskRequestDto.setTaskWriter(member.getMemberId());
        return taskAdaptor.updateTask(projectNo, memberNo, taskRequestDto);
    }

    @Override
    public String deleteTask(Long taskNo) {
        return taskAdaptor.deleteTask(taskNo);
    }
}
