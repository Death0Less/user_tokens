package com.example.user_tokens.service;

import com.example.user_tokens.dto.request.RoleRequest;
import com.example.user_tokens.mapper.RoleMapper;
import com.example.user_tokens.model.Role;
import com.example.user_tokens.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    @Transactional
    public void save(RoleRequest roleRequest) {
        Role role = roleMapper.mapRoleDtoToRole(roleRequest);
        roleRepository.save(role);
    }

    @Transactional
    public void deleteById(long id) {
        Role role = roleRepository.findById(id).orElseThrow(NullPointerException::new);
        roleRepository.delete(role);
    }
}
