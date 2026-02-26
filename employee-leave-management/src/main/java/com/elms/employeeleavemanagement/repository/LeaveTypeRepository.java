package com.elms.employeeleavemanagement.repository;

import com.elms.employeeleavemanagement.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {
}