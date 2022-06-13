package com.nhnacademy.minidoorayclient.controller;

import com.nhnacademy.minidoorayclient.dto.member.request.MemberRequestDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.validation.BindingResult;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberControllerTest {

    @SpyBean
    private MemberController mockMemberController;

    @MockBean
    private BindingResult mockBindingResult;

    @MockBean
    private MemberRequestDto mockMemberRequestDto;

    @Test
    void doRegisterValidExceptionTest() {
        when(mockBindingResult.hasErrors()).thenReturn(true);
        assertThatThrownBy(() -> mockMemberController.doRegister(mockMemberRequestDto, mockBindingResult));
    }
}

