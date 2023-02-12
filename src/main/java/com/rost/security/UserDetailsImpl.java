package com.rost.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rost.models.Principal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
@Getter
public class UserDetailsImpl implements UserDetails {
    private final Principal principal;

    /**
     * Необходимо формальное шифрование возвращаемого пароля из данной обёртки
     * в отсутствии кастомного {@link AuthenticationProvider}.
     * В противном случае выбрасывается {@link IllegalArgumentException}
     * с сообщением: There is no PasswordEncoder mapped for the id “null”.
     */
    private final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * Также есть возможность сделать конкатенацию вида:
     * {noop} + {@link #getPassword()}
     * и тогда нет необходимости задавать {@link #encoder}.
     *
     * @return зашифрованный пароль
     */
    @Override
    public String getPassword() {
        log.info("providing the password: \"{}\"", principal.getPassword());
        log.info("encoder class is {}", encoder.getClass().getSimpleName());
        return encoder.encode(principal.getPassword());
    }

    @Override
    public String getUsername() {
        return principal.getUsername();
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

    @Override
    public String toString() {
        return String.format("user: %s; authorities: %s", getUsername(), getAuthorities().isEmpty() ? "no" : getAuthorities());
    }
}
