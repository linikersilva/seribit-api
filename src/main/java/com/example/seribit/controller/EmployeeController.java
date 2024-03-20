package com.example.seribit.controller;

import com.example.seribit.dto.EmployeeDTO;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.dto.javaxgroups.UpdateGroup;
import com.example.seribit.entity.Employee;
import com.example.seribit.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seribit-api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody
                                                   @Validated(CreateGroup.class)
                                                   EmployeeDTO employeeDTO) {
        Employee newEmployee = employeeService.createEmployee(employeeDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getEmployeeId())
                .toUri();

        return ResponseEntity.created(uri).body(newEmployee);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeId,
                                                   @RequestBody
                                                   @Validated(UpdateGroup.class)
                                                   EmployeeDTO employeeDTO) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(employeeId, employeeDTO));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
