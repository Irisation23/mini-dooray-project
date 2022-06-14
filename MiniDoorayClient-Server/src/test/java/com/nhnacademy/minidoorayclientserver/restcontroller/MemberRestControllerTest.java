package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberRegisterRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberUpdateRequestDto;
import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.entity.authority.Authority;
import com.nhnacademy.minidoorayclientserver.entity.status.Status;
import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
import com.nhnacademy.minidoorayclientserver.service.MemberService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
                , Status.ACTIVATION
                , Authority.ROLE_USER
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
        MemberRegisterRequestDto memberRegisterRequestDto = new MemberRegisterRequestDto(null
                , null
                , null
                );

        String userDtoJsonString = objectMapper.writeValueAsString(memberRegisterRequestDto);

        mockMvc.perform(post("/member/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJsonString))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateApiToUpdateMemberValidation() throws Exception {
        MemberUpdateRequestDto memberUpdateRequestDto = new MemberUpdateRequestDto("kim"
                , "123"
                , "123@naver.com"
                , "여기는 사이즈 오류가 걸림!");

        String userDtoJsonString = objectMapper.writeValueAsString(memberUpdateRequestDto);

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
                .memberStatus(Status.ACTIVATION)
                .memberAuthority(Authority.ROLE_USER)
                .build();

        memberRepository.saveAndFlush(member);

        MemberUpdateRequestDto memberUpdateRequestDto = new MemberUpdateRequestDto("kim"
                , "1234"
                , "bunsung92@naver.com"
                , "hi");

        when(memberRepository.findById(15L)).thenReturn(Optional.of(member));
        when(memberRepository.findByMemberNo(15L)).thenReturn(MemberResponseDto.builder()
                .memberEmail("bunsung92@naver.com")
                .memberId("kim")
                .memberStatus("hi")
                .memberStatus(Status.ACTIVATION.toString())
                .memberAuthority(Authority.ROLE_USER.toString())
                .build());

        when(memberService.updateToMember(memberUpdateRequestDto, 15L)).thenReturn(MemberResponseDto.builder()
                        .memberEmail("bunsung92@naver.com")
                        .memberId("kim")
                        .memberStatus("hi")
                        .memberStatus(Status.ACTIVATION.toString())
                        .memberAuthority(Authority.ROLE_USER.toString())
                        .build());

        String userDtoJsonString = objectMapper.writeValueAsString(memberUpdateRequestDto);

        mockMvc.perform(post("/member/15/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJsonString))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findByMemberEmailSuccess() throws Exception {
        mockMvc.perform(get("/member?email=gnsals4848@naver.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findByMemberEmailFail() throws Exception {
        mockMvc.perform(get("/member?emai=  ")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
