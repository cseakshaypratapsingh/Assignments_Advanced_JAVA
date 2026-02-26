package com.elms.employeeleavemanagement.repository;

import com.elms.employeeleavemanagement.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {

    List<LeaveRequest> findByEmployeeEmployeeId(Integer employeeId);
}