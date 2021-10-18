package com.example.user_tokens.controller;

import com.example.user_tokens.dto.FilterDto;
import com.example.user_tokens.dto.request.EmployeeRequest;
import com.example.user_tokens.dto.response.EmployeeResponse;
import com.example.user_tokens.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse save(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.save(employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @GetMapping
    public List<EmployeeResponse> findAll(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @GetMapping("/filters")
    public List<EmployeeResponse> findByFilters(FilterDto filterDto, Pageable pageable) {
        return employeeService.findByFilters(filterDto, pageable);
    }

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable long id, @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(id, employeeRequest);
    }
}
