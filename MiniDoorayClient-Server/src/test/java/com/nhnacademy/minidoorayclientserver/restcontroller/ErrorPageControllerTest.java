package com.nhnacademy.minidoorayclientserver.restcontroller;

import com.nhnacademy.minidoorayclientserver.repository.MemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
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
    private MemberRepository memberRepository;

    @MockBean
    HttpServletRequest httpServletRequest;

    @SpyBean
    ErrorPageController errorPageController;

    @Test
    void handleError404() throws Exception {
        this.mockMvc.perform(get("/memeberrrr")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) errorPageController.handleError(httpServletRequest));
    }
}
