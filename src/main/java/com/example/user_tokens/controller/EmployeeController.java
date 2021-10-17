package com.example.user_tokens.controller;

import com.example.user_tokens.dto.request.EmployeeRequest;
import com.example.user_tokens.dto.response.EmployeeResponse;
import com.example.user_tokens.model.Employee;
import com.example.user_tokens.service.EmployeeService;
import liquibase.pro.packaged.L;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll();
    }

   @GetMapping("/dateMore")
    public List<EmployeeResponse> findByBirthDateMore(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate) {
        return employeeService.findByBirthDateMore(birthDate);
   }

   @GetMapping("/dateLess")
   public List<EmployeeResponse> findBirthDateLess(@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate) {
        return employeeService.findByBirthDateLess(birthDate);
   }

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable long id, @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(id, employeeRequest);
    }
}
