package com.nhnacademy.minidoorayclient.adaptor.project;

import com.nhnacademy.minidoorayclient.dto.member.response.ProjectResponseDto;
import com.nhnacademy.minidoorayclient.dto.project.request.ProjectRequestDto;

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
public class ProjectAdaptorImpl implements ProjectAdaptor {

    private final RestTemplate restTemplate;

    @Override
    public String registerProject(ProjectRequestDto projectRequestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectRequestDto> httpEntity = new HttpEntity<>(projectRequestDto, headers);
        HttpEntity<String> response = restTemplate.exchange("http://localhost:10090/project/register"
                , HttpMethod.POST
                , httpEntity
                , String.class
        );

        return response.getBody();
    }

    @Override
    public ProjectResponseDto projectReadToProjectNo(Long projectNo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        HttpEntity<ProjectResponseDto> response = restTemplate.exchange("http://localhost:10090/project/" + projectNo
                , HttpMethod.GET
                , httpEntity
                , ProjectResponseDto.class
        );

        return response.getBody();
    }

}
