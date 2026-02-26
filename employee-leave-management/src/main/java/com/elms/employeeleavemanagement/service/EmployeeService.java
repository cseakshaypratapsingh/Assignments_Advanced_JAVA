package com.elms.employeeleavemanagement.service;

import com.elms.employeeleavemanagement.model.Employee;
import com.elms.employeeleavemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Employee findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}