package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
import com.nhnacademy.minidoorayclientserver.service.MemberService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberRestControllerTest {

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private MemberService memberService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerToMember() throws Exception {
        Member member = new Member(15L
                , "hello"
                , "qweorjroiw#@@#@$@#"
                , "bunsung123@naver.com"
                , "join"
        );
        memberRepository.saveAndFlush(member);

        String requestBody = new ObjectMapper().writeValueAsString(member);
        this.mockMvc.perform(
                        post("/member/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void restApiToRegisterMemberValidation() throws Exception {
        MemberRequestDto memberRequestDto = new MemberRequestDto(null
                , null
                , null
                , null);

        String userDtoJsonString = objectMapper.writeValueAsString(memberRequestDto);

        mockMvc.perform(post("/member/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJsonString))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateApiToUpdateMemberValidation() throws Exception {
        MemberRequestDto memberRequestDto = new MemberRequestDto("kim"
                , "123"
                , "123@naver.com"
                , "여기는 사이즈 오류가 걸림!");

        String userDtoJsonString = objectMapper.writeValueAsString(memberRequestDto);

        mockMvc.perform(post("/member/13/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJsonString))
                .andExpect(status().isBadRequest());
    }


    @Test
    void updateApiToUpdateMember() throws Exception {

        Member member = Member.builder()
                .memberNo(15L)
                .memberId("kim")
                .memberPassword("12345")
                .memberEmail("123@naver.com")
                .memberStatus("join")
                .build();

        memberRepository.saveAndFlush(member);

        MemberRequestDto memberRequestDto = new MemberRequestDto("kim"
                , "1234"
                , "bunsung92@naver.com"
                , "hi");

        String userDtoJsonString = objectMapper.writeValueAsString(memberRequestDto);

        when(memberRepository.findById(15L)).thenReturn(Optional.of(member));
        when(memberRepository.findByMemberNo(15L)).thenReturn(MemberResponseDto.builder()
                .memberEmail("bunsung92@naver.com")
                .memberId("kim")
                .memberStatus("hi")
                .build());

        when(memberService.updateToMember(memberRequestDto, 15L)).thenReturn(MemberResponseDto.builder()
                        .memberEmail("bunsung92@naver.com")
                        .memberId("kim")
                        .memberStatus("hi")
                .build());
        mockMvc.perform(post("/member/15/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJsonString))
                .andExpect(status().is2xxSuccessful());
    }
}
