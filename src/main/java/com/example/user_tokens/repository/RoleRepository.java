package com.example.user_tokens.repository;

import com.example.user_tokens.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByName(String name);
    void deleteByName(String name);
    Role findByName(String name);
}
