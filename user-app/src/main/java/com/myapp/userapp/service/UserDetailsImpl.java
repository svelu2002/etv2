package com.myapp.userapp.service;

import com.myapp.userapp.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private String role;
    public UserDetailsImpl(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.role = userEntity.getRole();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(role.split(","))
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim().toUpperCase()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
