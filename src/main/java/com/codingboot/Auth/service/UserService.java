package com.codingboot.Auth.service;

import com.codingboot.Auth.domain.entity.Role;
import com.codingboot.Auth.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    List<User> getUsers();
    User findByEmail(String email);
}
