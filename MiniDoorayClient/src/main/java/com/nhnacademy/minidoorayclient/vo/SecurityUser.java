package com.nhnacademy.minidoorayclient.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class SecurityUser implements UserDetails {

    @NotBlank
    private Long memberNo;
    @NotBlank
    @Size(max = 20)
    private String memberId;
    @NotBlank
    @Size(max = 100)
    private String memberPassword;
    @NotBlank
    @Size(max = 100)
    private String memberEmail;
    @NotBlank
    @Size(max = 10)
    private String memberStatus;
    @NotEmpty
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.memberPassword;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
