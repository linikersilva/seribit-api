package com.example.seribit.controller;

import com.example.seribit.dto.LoginDTO;
import com.example.seribit.entity.Employee;
import com.example.seribit.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seribit-api/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<Employee> performLogin(@RequestBody @Valid LoginDTO loginDTO) {
        return ResponseEntity.ok(loginService.performLogin(loginDTO));
    }
}
