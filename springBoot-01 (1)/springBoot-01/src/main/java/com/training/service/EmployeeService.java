package com.training.service;

import com.training.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employee);

    EmployeeDto getEmpByID(long empid);

    EmployeeDto updateEmployeeById(Long empid, EmployeeDto employee);

    void deleteById(Long empid);

    EmployeeDto updateEmployee(Long empid, EmployeeDto employee);
}
