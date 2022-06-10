package com.nhnacademy.minidoorayclientserver.restcontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                modelAndView.addObject("exception"
                        , "해당 페이지는 없습니다.");
                modelAndView.addObject("statusCode"
                        , statusCode);
                return modelAndView;
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                modelAndView.addObject("exception"
                        , "요청을 처리하는 과정에서 서버가 예상하지 못한 상황을 직면했습니다.");
                modelAndView.addObject("statusCode"
                        , statusCode);
                return modelAndView;
            }
        }

        return modelAndView;
    }
}
