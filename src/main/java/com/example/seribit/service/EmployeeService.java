package com.example.seribit.service;

import com.example.seribit.dto.EmployeeDTO;
import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.entity.Employee;
import com.example.seribit.exception.handler.EntityNotFoundException;
import com.example.seribit.mapper.EmployeeMapper;
import com.example.seribit.repository.EmployeeRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final Validator validator;

    public Employee getEmployeeById(Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.orElseThrow(() -> new EntityNotFoundException("O funcionário não foi encontrado!"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = employeeMapper.mapFromDtoToEntity(employeeDTO);
        return employeeRepository.save(newEmployee);
    }

    public Employee updateEmployee(Integer employeeId, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(employeeId);

        if (!allAttributesAreNull(employeeDTO)) {
            employeeMapper.updateEntity(employeeDTO, employee);
        }

        return employeeRepository.save(employee);
    }

    private boolean allAttributesAreNull(EmployeeDTO employeeDTO) {
        Set<ConstraintViolation<EmployeeDTO>> violations =
                validator.validate(employeeDTO, AllAttributesNullCheckGroup.class);

        return violations.size() == 13;
    }

    public void deleteEmployee(Integer employeeId) {
        Employee employee = getEmployeeById(employeeId);
        employeeRepository.delete(employee);
    }
}
