package com.nhnacademy.minidoorayclient.adaptor;

import com.nhnacademy.minidoorayclient.dto.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberAdaptorImpl implements MemberAdaptor {

    private final RestTemplate restTemplate;

    @Override
    public String register(MemberRequestDto memberRequestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<MemberRequestDto> httpEntity = new HttpEntity<>(memberRequestDto, headers);

        HttpEntity<MemberResponseDto> response = restTemplate.exchange(
                "http://localhost:9090/member/register",
                HttpMethod.POST,
                httpEntity,
                MemberResponseDto.class
        );

        MemberResponseDto memberResponseDto = response.getBody();

        if(memberResponseDto == null) {
            throw new IllegalStateException();
        }

        return memberResponseDto.getMemberId();
    }
//
//    @Override
//    public void register(MemberRequestDto memberRequestDto) {
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//
//        ResponseEntity<UserLoginResponseDto> responseEntity = restTemplate.exchange(
//                "http://localhost:9090/login?username={username}"
//                , POST
//                , httpEntity
//                , UserLoginResponseDto.class
//                , username
//        );
}
