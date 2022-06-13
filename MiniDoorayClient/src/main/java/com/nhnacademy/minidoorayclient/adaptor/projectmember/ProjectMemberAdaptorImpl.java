package com.nhnacademy.minidoorayclient.adaptor.projectmember;


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
public class ProjectMemberAdaptorImpl implements ProjectMemberAdaptor {

    private final RestTemplate restTemplate;

    @Override
    public String registerProjectMemberToProject(Long projectNo, Long memberNo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange("http://localhost:10090/project/" + projectNo + "/member" + memberNo + "/register"
                , HttpMethod.GET
                , httpEntity
                , String.class
        );

        return response.getBody();
    }

}
