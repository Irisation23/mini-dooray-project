package com.nhnacademy.minidoorayclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/resident").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/admin/**").requiresSecure()
                .antMatchers("/private-project/**").requiresSecure()
                .antMatchers("/project/**").requiresSecure()
                .anyRequest().requiresInsecure()
                .and()
                .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                //.successHandler(loginSuccessHandler())
                .and()
                .logout()
                .logoutSuccessUrl("/auth/login")
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionFixation()
                .none()
                .and()
                .headers()
                .defaultsDisabled()
                .frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403")
                .and();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
