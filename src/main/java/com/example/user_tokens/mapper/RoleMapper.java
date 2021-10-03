package com.example.user_tokens.mapper;

import com.example.user_tokens.dto.request.RoleRequest;
import com.example.user_tokens.model.Role;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RoleMapper {

    public Role mapRoleDtoToRole(RoleRequest roleRequest) {
        return Role.builder()
                .name(roleRequest.getName())
                .creationDate(roleRequest.getCreationDate())
                .build();
    }
}
