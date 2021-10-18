package com.example.user_tokens.service;

import com.example.user_tokens.dto.request.EmployeeRequest;
import com.example.user_tokens.dto.response.EmployeeResponse;
import com.example.user_tokens.mapper.EmployeeMapper;
import com.example.user_tokens.model.Employee;
import com.example.user_tokens.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EntityManager entityManager;

    @Transactional
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.mapEmployeeDtoToEmployee(employeeRequest);
        employeeRepository.save(employee);
        return employeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    @Transactional
    public void deleteById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(NullPointerException::new);
        employeeRepository.delete(employee);
    }

    public EmployeeResponse findById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(NullPointerException::new);
        return employeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    public List<EmployeeResponse> findAll(int offset, int size) {
        List employees = entityManager
                .createQuery("select e from Employee e")
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
        return employeeMapper.mapEmployeeListToEmployeeListDto(employees);
    }

    public List<EmployeeResponse> findByBirthDateMore(Date birthDate, int offset, int size) {
        List employees = entityManager
                .createQuery("SELECT e from Employee e where e.birthday >: birthDate")
                .setParameter("birthDate", birthDate)
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
        return employeeMapper.mapEmployeeListToEmployeeListDto(employees);
    }

    public List<EmployeeResponse> findByBirthDateLess(Date birthDate, int offset, int size) {
        List employees = entityManager.createQuery("select e from Employee e where e.birthday <: birthDate")
                .setParameter("birthDate", birthDate)
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
        return employeeMapper.mapEmployeeListToEmployeeListDto(employees);
    }

    public List<EmployeeResponse> findByIdNumber(String idNumber, int offset, int size) {
        List employees = entityManager.createQuery("select e from Employee e where e.idNumber LIKE : idNumber")
                .setParameter("idNumber", "%"+idNumber+"%")
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
        return employeeMapper.mapEmployeeListToEmployeeListDto(employees);
    }

    public EmployeeResponse update(long id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(NullPointerException::new);
        updateEmployeeFromDto(employeeRequest, employee);
        employee = employeeRepository.save(employee);
        return employeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    private void updateEmployeeFromDto(EmployeeRequest employeeRequest, Employee employee) {
        if (employeeRequest.getFirstName() != null) {
            employee.setFirstName(employeeRequest.getFirstName());
        }
        if (employeeRequest.getLastName() != null) {
            employee.setLastName(employeeRequest.getLastName());
        }
        if (employeeRequest.getPatronymic() != null) {
            employee.setPatronymic(employeeRequest.getPatronymic());
        }
        if (employeeRequest.getIdNumber() != null) {
            employee.setIdNumber(employeeRequest.getIdNumber());
        }
        if (employeeRequest.getBirthday() != null) {
            employee.setBirthday(employeeRequest.getBirthday());
        }
        if (employeeRequest.getStatus() != null) {
            employee.setStatus(employeeRequest.getStatus());
        }
    }
}
