package com.springboot.test.employee;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    public List<EmployeeResponse> findAllEmployee() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
    public Employee create(EmployeeRequest employee) {
        var emp = mapper.toEmployee(employee);
        return repository.save(emp);
    }
    public EmployeeResponse findSingleEmpl(Long id) {
        return repository.findEmployeeById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No Employee found with the ID::" + id));
    }
    public Employee updateEmployee(Long id,EmployeeRequest employee) {
        Employee existingEmployee= repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        var emp = mapper.toEmployee(employee);
        if (emp.getName()!=null) existingEmployee.setName(emp.getName());
        if (emp.getEmail()!=null) existingEmployee.setEmail(emp.getEmail());
        if (emp.getJobTitle()!=null) existingEmployee.setJobTitle(emp.getJobTitle());
        if (emp.getPhone()!=null) existingEmployee.setPhone(emp.getPhone());
        if (emp.getImageUrl()!=null) existingEmployee.setImageUrl(emp.getImageUrl());
        return repository.save(existingEmployee);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
