package com.example.seribit.mapper;

import com.example.seribit.dto.EmployeeDTO;
import com.example.seribit.entity.Address;
import com.example.seribit.entity.Employee;
import com.example.seribit.entity.Phone;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final ModelMapper modelMapper;

    public Employee mapFromDtoToEntity(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setAddress(Address.builder()
                                   .street(employeeDTO.getStreet())
                                   .number(employeeDTO.getNumber())
                                   .neighborhood(employeeDTO.getNeighborhood())
                                   .state(employeeDTO.getState().toUpperCase())
                                   .cep(employeeDTO.getCep())
                                   .complement(employeeDTO.getComplement())
                                   .build()
        );
        employee.setPhone(Phone.builder()
                               .phone(employeeDTO.getPhone())
                               .ddd(employeeDTO.getDdd())
                               .build()
        );
        return employee;
    }

    public void updateEntity(EmployeeDTO employeeDTO, Employee employee) {
        employee.setName(Optional.ofNullable(employeeDTO.getName()).orElse(employee.getName()));
        employee.setEmail(Optional.ofNullable(employeeDTO.getEmail()).orElse(employee.getEmail()));
        employee.setCpf(Optional.ofNullable(employeeDTO.getCpf()).orElse(employee.getCpf()));
        employee.setUser(Optional.ofNullable(employeeDTO.getUser()).orElse(employee.getUser()));
        employee.setPassword(Optional.ofNullable(employeeDTO.getPassword()).orElse(employee.getPassword()));
        employee.setSalary(Optional.ofNullable(employeeDTO.getSalary()).orElse(employee.getSalary()));

        Address address = employee.getAddress();
        address.setStreet(Optional.ofNullable(employeeDTO.getStreet()).orElse(address.getStreet()));
        address.setNumber(Optional.ofNullable(employeeDTO.getNumber()).orElse(address.getNumber()));
        address.setNeighborhood(Optional.ofNullable(employeeDTO.getNeighborhood()).orElse(address.getNeighborhood()));
        address.setState(Optional.ofNullable(employeeDTO.getState()).orElse(address.getState()));
        address.setCep(Optional.ofNullable(employeeDTO.getCep()).orElse(address.getCep()));
        address.setComplement(Optional.ofNullable(employeeDTO.getComplement()).orElse(address.getComplement()));

        Phone phone = employee.getPhone();
        phone.setPhone(Optional.ofNullable(employeeDTO.getPhone()).orElse(phone.getPhone()));
        phone.setDdd(Optional.ofNullable(employeeDTO.getDdd()).orElse(phone.getDdd()));
    }
}
