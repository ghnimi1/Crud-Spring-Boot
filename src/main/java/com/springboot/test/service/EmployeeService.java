package com.springboot.test.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.springboot.test.entity.Employee;
import com.springboot.test.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee createEmployee (Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee updateEmployee(Long id,Employee employee) {
        Employee existingEmployee= employeeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        if (employee.getName()!=null) existingEmployee.setName(employee.getName());
        if (employee.getEmail()!=null) existingEmployee.setEmail(employee.getEmail());
        if (employee.getJobTitle()!=null) existingEmployee.setJobTitle(employee.getJobTitle());
        if (employee.getPhone()!=null) existingEmployee.setPhone(employee.getPhone());
        if (employee.getImageUrl()!=null) existingEmployee.setImageUrl(employee.getImageUrl());
        return employeeRepo.save(existingEmployee);
    }
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }


    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}