package com.rost.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rost.models.Principal;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class UserDetailsImpl implements UserDetails {
    private final Principal principal;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return principal.getPassword();
    }

    @Override
    public String getUsername() {
        return principal.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //stub
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //stub
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //stub
    }

    @Override
    public boolean isEnabled() {
        return true; //stub
    }
}
