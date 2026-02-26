package com.elms.employeeleavemanagement.service;

import com.elms.employeeleavemanagement.model.LeaveRequest;
import com.elms.employeeleavemanagement.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository repository;

    public LeaveRequestService(LeaveRequestRepository repository) {
        this.repository = repository;
    }

    public void applyLeave(LeaveRequest request) {
        request.setStatus("Pending");
        repository.save(request);
    }

    public List<LeaveRequest> findAll() {
        return repository.findAll();
    }

    public void updateStatus(Integer id, String status) {
        LeaveRequest request = repository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus(status);
            repository.save(request);
        }
    }

    public List<LeaveRequest> findByEmployee(Integer employeeId) {
        return repository.findByEmployeeEmployeeId(employeeId);
    }
}