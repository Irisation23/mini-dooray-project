package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ErrorPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Test
    void handleError404() throws Exception {
        this.mockMvc.perform(get("/memeberrrr")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> new ErrorPageController());
    }

    @Test
    @Timeout(100)
    void handleErrorTimeOut() throws Exception {
        this.mockMvc.perform(post("/member/regiser")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> new ErrorPageController());
    }
}
