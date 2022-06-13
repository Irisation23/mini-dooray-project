package com.nhnacademy.minidoorayclient.adaptor.task;

import com.nhnacademy.minidoorayclient.dto.member.request.TaskRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskAdaptorImpl implements TaskAdaptor {
    private final RestTemplate restTemplate;

    @Override
    public String registerTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskRequestDto> httpEntity = new HttpEntity<>(taskRequestDto, headers);
        HttpEntity<String> response = restTemplate.exchange("http://localhost:10090/project/" + projectNo + "/member/" + memberNo + "/task/register"
                , HttpMethod.POST
                , httpEntity
                , String.class
        );

        return response.getBody();
    }

    @Override
    public String updateTask(Long projectNo, Long memberNo, TaskRequestDto taskRequestDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskRequestDto> httpEntity = new HttpEntity<>(taskRequestDto, headers);
        HttpEntity<String> response = restTemplate.exchange("http://localhost:10090/project/" + projectNo + "/member/" + memberNo + "/task/update"
                , HttpMethod.POST
                , httpEntity
                , String.class
        );

        return response.getBody();
    }

    @Override
    public String deleteTask(Long taskNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange("http://localhost:10090/task/delete/"+taskNo
                , HttpMethod.GET
                , httpEntity
                , String.class
        );

        return response.getBody();
    }
}
