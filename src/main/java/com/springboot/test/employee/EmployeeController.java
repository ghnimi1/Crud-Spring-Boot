package com.springboot.test.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(service.findAllEmployee());
    }
    @PostMapping
    public Employee save(
            @RequestBody EmployeeRequest employee
    ) {
        return service.create(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmp(
            @PathVariable Long id,
            @RequestBody EmployeeRequest employee
    ) {
        return service.updateEmployee(id,employee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findSingleEmpl(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(service.findSingleEmpl(id));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(
            @PathVariable("id") Long id
    ) {
        service.delete(id);
    }
}
