package com.elms.employeeleavemanagement.repository;

import com.elms.employeeleavemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}