package com.springboot.test.employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEmployee(EmployeeRequest employee){
        return  Employee.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .jobTitle(employee.getJobTitle())
                .imageUrl(employee.getImageUrl())
                .build();
    }
    public EmployeeResponse toResponse(Employee employee){
        return  EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .jobTitle(employee.getJobTitle())
                .imageUrl(employee.getImageUrl())
                .build();
    }


}
