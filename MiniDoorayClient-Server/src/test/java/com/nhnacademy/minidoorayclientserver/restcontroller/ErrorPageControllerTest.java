package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclientserver.entity.Member;
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
import javax.servlet.http.HttpServletRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ErrorPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Test
    void handleError404() throws Exception {

        Member member = new Member(15L
                , "hello"
                , "qweorjroiw#@@#@$@#"
                , "bunsung123@naver.com"
                , "join"
        );

        String requestBody = new ObjectMapper().writeValueAsString(member);
        this.mockMvc.perform(
                        get("/error")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(result -> new ErrorPageController());

    }
}
