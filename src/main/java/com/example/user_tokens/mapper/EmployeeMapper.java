package com.example.user_tokens.mapper;

import com.example.user_tokens.dto.request.EmployeeRequest;
import com.example.user_tokens.dto.response.EmployeeResponse;
import com.example.user_tokens.model.Employee;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
@NoArgsConstructor
public class EmployeeMapper {

    public Employee mapEmployeeDtoToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .patronymic(employeeRequest.getPatronymic())
                .idNumber(employeeRequest.getIdNumber())
                .birthday(employeeRequest.getBirthday())
                .status(employeeRequest.getStatus())
                .build();
    }

    public EmployeeResponse mapEmployeeToEmployeeDto(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .patronymic(employee.getPatronymic())
                .idNumber(employee.getIdNumber())
                .birthday(employee.getBirthday())
                .birthday(employee.getBirthday())
                .status(employee.getStatus())
                .build();
    }

    public List<EmployeeResponse> mapEmployeeListToEmployeeListDto(List<Employee> employeeList) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeResponse employeeResponse = mapEmployeeToEmployeeDto(employee);
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }
}
