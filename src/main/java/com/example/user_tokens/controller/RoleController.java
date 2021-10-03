package com.example.user_tokens.controller;

import com.example.user_tokens.dto.request.RoleRequest;
import com.example.user_tokens.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public void save(@RequestBody RoleRequest roleRequest) {
        roleService.save(roleRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        roleService.deleteById(id);
    }
}
