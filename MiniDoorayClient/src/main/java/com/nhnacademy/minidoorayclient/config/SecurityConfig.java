package com.nhnacademy.minidoorayclient.config;

import com.nhnacademy.minidoorayclient.auth.LoginSuccessHandler;
import com.nhnacademy.minidoorayclient.service.UserDetailsCustomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/member/register").permitAll()
                .anyRequest().hasAuthority("ROLE_USER")
                .and()
                .formLogin()
                .successHandler(loginSuccessHandler())
                .usernameParameter("memberId")
                .passwordParameter("memberPassword")
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();
        http.headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403")
                .and();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            UserDetailsCustomService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }
}
