package com.codingboot.Auth.config;

import com.codingboot.Auth.domain.entity.User;
import com.codingboot.Auth.domain.exception.AuthExceptionHandling;
import com.codingboot.Auth.domain.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new AuthExceptionHandling(HttpStatus.BAD_REQUEST.value(), "Email has not been registered", null);
        return UserDetailsImpl.build(user);
    }
}