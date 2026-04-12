package com.training.controller;

import com.training.Dto.EmployeeDto;
import com.training.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{empid}")
    public ResponseEntity<EmployeeDto> getEmpByID(@PathVariable Long empid) {
        return ResponseEntity.ok(service.getEmpByID(empid));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createEmployee(employee));
    }

    @PutMapping("/{empid}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable Long empid,
            @Valid @RequestBody EmployeeDto employee) {

        return ResponseEntity.ok(service.updateEmployeeById(empid, employee));
    }

    @DeleteMapping("/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long empid) {
        service.deleteById(empid);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{empid}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable Long empid,
            @RequestBody EmployeeDto employee) {

        return ResponseEntity.ok(service.updateEmployee(empid, employee));
    }
}