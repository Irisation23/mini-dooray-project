package com.nhnacademy.minidoorayclient.adaptor.member;

import com.nhnacademy.minidoorayclient.dto.member.request.MemberRequestDto;
import com.nhnacademy.minidoorayclient.dto.member.response.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
        HttpEntity<MemberResponseDto> response = restTemplate.exchange("http://localhost:9090/member/register"
                , HttpMethod.POST
                , httpEntity
                , MemberResponseDto.class
        );
        MemberResponseDto memberResponseDto = response.getBody();
        if (memberResponseDto == null) {
            throw new IllegalStateException();
        }

        return memberResponseDto.getMemberId();
    }

    @Override
    public MemberResponseDto getByMemberName(String username) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        HttpEntity<MemberResponseDto> responseDtoHttpEntity = restTemplate.exchange("http://localhost:9090/member/check?username={username}"
                , HttpMethod.GET
                , httpEntity
                , MemberResponseDto.class
                , username
        );

        return responseDtoHttpEntity.getBody();
    }

    @Override
    public MemberResponseDto findByMemberEmail(String email) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        HttpEntity<MemberResponseDto> responseDtoHttpEntity = restTemplate.exchange("http://localhost:9090/member?email={email}"
                , HttpMethod.GET
                , httpEntity
                , MemberResponseDto.class
                , email);

        return responseDtoHttpEntity.getBody();
    }

    @Override
    public List<MemberResponseDto> findAllMember() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<List<MemberResponseDto>> httpEntity = new HttpEntity<>(headers);
        HttpEntity<List<MemberResponseDto>> responseDtoHttpEntityList = restTemplate.exchange("http://localhost:9090/member/list"
                , HttpMethod.GET
                , httpEntity
                , new ParameterizedTypeReference<List<MemberResponseDto>>() {
                });

        return responseDtoHttpEntityList.getBody();
    }

    @Override
    public MemberResponseDto getByMemberNo(Long memberNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        HttpEntity<MemberResponseDto> responseDtoHttpEntityList = restTemplate.exchange("http://localhost:9090/member/memberNo={memberNo}"
                , HttpMethod.GET
                , httpEntity
                , MemberResponseDto.class
        );

        return responseDtoHttpEntityList.getBody();
    }
}
