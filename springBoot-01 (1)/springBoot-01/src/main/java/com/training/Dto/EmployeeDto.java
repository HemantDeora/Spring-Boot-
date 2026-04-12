package com.training.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private long empID;
    private String empName;
    private double salary;
    private String dept;
}
