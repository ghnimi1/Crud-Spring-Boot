package com.springboot.test.controller;

import java.util.List;

import com.springboot.test.entity.Employee;
import com.springboot.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees =employeeService.findAllEmployees();

        return new  ResponseEntity<>(employees,HttpStatus.OK);
    }
    @PostMapping("/")
    public  ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmpl = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee>  updateEmploee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(id,employee);
        return new  ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){

        employeeService.deleteEmployee(id);
    }
}