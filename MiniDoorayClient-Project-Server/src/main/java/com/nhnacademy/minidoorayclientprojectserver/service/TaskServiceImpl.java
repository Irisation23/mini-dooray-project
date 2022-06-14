package com.nhnacademy.minidoorayclientprojectserver.service;

import com.nhnacademy.minidoorayclientprojectserver.dto.request.TaskRequestDto;
import com.nhnacademy.minidoorayclientprojectserver.entity.ProjectMember;
import com.nhnacademy.minidoorayclientprojectserver.entity.Task;
import com.nhnacademy.minidoorayclientprojectserver.exception.NotFindProjectMemberException;
import com.nhnacademy.minidoorayclientprojectserver.exception.NotFindTaskException;
import com.nhnacademy.minidoorayclientprojectserver.repository.ProjectMemberRepository;
import com.nhnacademy.minidoorayclientprojectserver.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public String registerTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto) {

        ProjectMember.ProjectMemberPk projectMemberPk =
                new ProjectMember.ProjectMemberPk(memberNo, projectNo);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberPk)
                .orElseThrow(() -> new NotFindProjectMemberException("해당 멤버는 존재하지 않습니다."));

        Task task = Task.builder()
                .taskTitle(taskRequestDto.getTaskTitle())
                .taskContent(taskRequestDto.getTaskContent())
                .taskDate(LocalDate.now())
                .taskWriter(projectMember.getProjectMemberName())
                .build();

        taskRepository.saveAndFlush(task);

        return "업무가 생성 되었습니다.";
    }

    @Override
    public String updateTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto) {

        ProjectMember.ProjectMemberPk projectMemberPk =
                new ProjectMember.ProjectMemberPk(memberNo, projectNo);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberPk)
                .orElseThrow(() -> new NotFindProjectMemberException("해당 멤버는 존재하지 않습니다."));

        Task task = taskRepository.findByTaskWriter(taskRequestDto.getTaskWriter())
                .orElseThrow(() -> new NotFindTaskException("해당 업무는 존재하지 않습니다."));

        task.setTaskDate(LocalDate.now());
        task.setTaskWriter(taskRequestDto.getTaskWriter());

        taskRepository.saveAndFlush(task);

        return "업무가 수정 되었습니다.";
    }

    @Override
    public String deleteTask(Long projectNo) {
        Task task = taskRepository.findById(projectNo)
                .orElseThrow(() -> new NotFindTaskException("해당 업무는 존재하지 않습니다."));

        taskRepository.delete(task);
        return "업무가 삭제 되었습니다.";
    }
}
