package com.example.seribit.service;

import com.example.seribit.dto.LoginDTO;
import com.example.seribit.entity.Employee;
import com.example.seribit.exception.EntityNotFoundException;
import com.example.seribit.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final EmployeeRepository employeeRepository;

    public Employee performLogin(LoginDTO loginDTO) {
        return employeeRepository.findByUserAndPassword(loginDTO.getUser(), loginDTO.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrado registro de usuário com as credenciais informadas."));
    }
}
