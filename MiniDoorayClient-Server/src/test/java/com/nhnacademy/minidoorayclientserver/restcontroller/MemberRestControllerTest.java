package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclientserver.dto.request.MemberRequestDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberRestControllerTest {

    @MockBean
    MemberRestController memberRestController;

    @MockBean
    private MemberRepository accountRepository;

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
        String requestBody = new ObjectMapper().writeValueAsString(member);

        given(accountRepository.findById(15L))
                .willReturn(Optional.empty());

        this.mockMvc.perform(
                        post("/member/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.memberId", equalTo("hello")));
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

}
