package com.training.service.impl;

import com.training.Dto.EmployeeDto;
import com.training.Entity.Employee;
import com.training.Repo.EmployeeRepo;
import com.training.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeDto> getAllEmployees() {


        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .toList();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Employee emoloyee = modelMapper.map(employee, Employee.class);
        Employee saved = employeeRepo.save(emoloyee);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmpByID(long empid) {

        Employee employee = employeeRepo.findById(empid).orElseThrow(() -> new IllegalArgumentException("id not found"));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long empid, EmployeeDto employee) {

        Employee emoloyee = employeeRepo.findById(empid).orElseThrow(() -> new IllegalArgumentException("id not found"));
        emoloyee.setEmpName(employee.getEmpName());
        emoloyee.setSalary(employee.getSalary());
        emoloyee.setDept(employee.getDept());

        Employee saved = employeeRepo.save(emoloyee);

        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public void deleteById(Long empid) {
        Employee employee = employeeRepo.findById(empid).orElseThrow(() -> new IllegalArgumentException("id not found"));
        employeeRepo.delete(employee);

    }

    @Override
    public EmployeeDto updateEmployee(Long empid, EmployeeDto employee) {
        Employee emoloyee = employeeRepo.findById(empid).orElseThrow(() -> new IllegalArgumentException("id not found"));
        if(employee.getEmpName() != null){
            emoloyee.setEmpName(employee.getEmpName());
        }
        if (employee.getSalary() != 0){
            emoloyee.setSalary(employee.getSalary());
        }

        if (employee.getDept() != null){
            emoloyee.setDept(employee.getDept());
        }

        Employee saved = employeeRepo.save(emoloyee);
        return modelMapper.map(saved, EmployeeDto.class);
    }


}
