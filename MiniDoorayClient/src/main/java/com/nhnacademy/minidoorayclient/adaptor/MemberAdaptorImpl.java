package com.nhnacademy.minidoorayclient.adaptor;

import com.nhnacademy.minidoorayclient.dto.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;


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

}
