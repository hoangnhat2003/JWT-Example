package com.codingboot.Auth.domain.repository;

import com.codingboot.Auth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
