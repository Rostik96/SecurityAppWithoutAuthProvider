package com.rost.security;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.rost.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final UserDetailsServiceImpl userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!password.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Incorrect password");

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                Collections.emptyList()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
