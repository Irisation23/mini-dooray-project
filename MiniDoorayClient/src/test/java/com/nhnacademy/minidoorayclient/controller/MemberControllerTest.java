package com.nhnacademy.minidoorayclient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclient.adaptor.MemberAdaptor;
import com.nhnacademy.minidoorayclient.dto.MemberRequestDto;
import com.nhnacademy.minidoorayclient.exception.ValidationFailedException;
import com.nhnacademy.minidoorayclient.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberControllerTest {

    @SpyBean
    private MemberAdaptor mockMemberAdaptor;

    @SpyBean
    private MemberController mockMemberController;

    @SpyBean
    private MemberService mockMemberService;

    @MockBean
    private BindingResult mockBindingResult;

    @MockBean
    private MemberRequestDto mockMemberRequestDto;

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @Test
    void doRegisterValidExceptionTest() throws Exception {
        when(mockBindingResult.hasErrors()).thenReturn(true);
        assertThatThrownBy(() -> mockMemberController.doRegister(mockMemberRequestDto, mockBindingResult));
    }

    @Test
    void doRegister() throws Exception {
        // TODO :  해당 테스트 진행 해야함.
        //  왜 String.class 는 String.valueOf() 로 감싸주어야 하나?
        //  이 테스트는 Adaptor 테스트 부터 다시 역으로 올라와야 짤 수있다라는 생각이 듬.
//        when(mockBindingResult.hasErrors()).thenReturn(false);
//        PasswordEncoder passwordEncoder = spy(PasswordEncoder.class);
//        when(passwordEncoder.encode(any())).thenReturn("1234");
//        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
//        when(bCryptPasswordEncoder.encode("1234")).thenReturn("12345");
//        assertThat(mockMemberController.doRegister(mockMemberRequestDto, mockBindingResult)).isInstanceOf(ModelAndView.class);
    }
}

