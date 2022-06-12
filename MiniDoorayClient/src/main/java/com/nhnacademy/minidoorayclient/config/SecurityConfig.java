package com.nhnacademy.minidoorayclient.config;

import com.nhnacademy.minidoorayclient.auth.LoginSuccessHandler;
import com.nhnacademy.minidoorayclient.service.UserDetailsCustomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
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
                .antMatchers("/member").hasAuthority("ROLE_USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("memberId")
                .passwordParameter("memberPassword")
                //.loginPage("/auth/login")
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .successHandler(loginSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/auth/login")
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
