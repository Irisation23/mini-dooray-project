package com.nhnacademy.minidoorayclientprojectserver.restcontroller;

import com.nhnacademy.minidoorayclientprojectserver.dto.request.TaskRequestDto;
import com.nhnacademy.minidoorayclientprojectserver.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaskRestController {
    private final TaskService taskService;

    @PostMapping(value = "/project/{projectNo}/member/{memberNo}/task/register")
    public String registerTask(@PathVariable Long projectNo
            , @PathVariable Long memberNo
            , @RequestBody TaskRequestDto taskRequestDto) {
        return taskService.registerTask(projectNo, memberNo, taskRequestDto);
    }

    @PostMapping(value = "/project/{projectNo}/member/{memberNo}/task/update")
    public String updateTask(@PathVariable Long projectNo
            , @PathVariable Long memberNo
            , @RequestBody TaskRequestDto taskRequestDto) {
        return taskService.updateTask(projectNo, memberNo, taskRequestDto);
    }

    @GetMapping(value = "/task/delete/{taskNo}")
    public String deleteTask(@PathVariable Long taskNo) {
        return taskService.deleteTask(taskNo);
    }
}
