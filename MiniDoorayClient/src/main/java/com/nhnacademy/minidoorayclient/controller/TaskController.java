package com.nhnacademy.minidoorayclient.controller;

import com.nhnacademy.minidoorayclient.dto.member.request.TaskRequestDto;
import com.nhnacademy.minidoorayclient.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/project/{projectNo}/member/{memberNo}/task/register")
    public ModelAndView doTaskRegister(@PathVariable(name = "projectNo") Long projectNo
            , @PathVariable(name = "memberNo") Long memberNo
            , TaskRequestDto taskRequestDto) {

        ModelAndView modelAndView = new ModelAndView("task-register-success");
        String message = taskService.registerTask(projectNo, memberNo, taskRequestDto);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping(value = "/project/{projectNo}/member/{memberNo}/task/update")
    public ModelAndView doTaskUpdate(@PathVariable(name = "projectNo") Long projectNo
            , @PathVariable(name = "memberNo") Long memberNo
            , TaskRequestDto taskRequestDto) {
        ModelAndView modelAndView = new ModelAndView("task-update-success");
        String message = taskService.updateTask(projectNo, memberNo, taskRequestDto);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @GetMapping(value = "/task/{taskNo}/delete")
    public ModelAndView TaskDelete(@PathVariable Long taskNo) {
        ModelAndView modelAndView = new ModelAndView("task-update-success");
        String message = taskService.deleteTask(taskNo);
        modelAndView.addObject("message", message);

        return modelAndView;
    }
}
