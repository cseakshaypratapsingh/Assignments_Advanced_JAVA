package com.elms.employeeleavemanagement.service;

import com.elms.employeeleavemanagement.model.LeaveType;
import com.elms.employeeleavemanagement.repository.LeaveTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeService {

    private final LeaveTypeRepository repository;

    public LeaveTypeService(LeaveTypeRepository repository) {
        this.repository = repository;
    }

    public void save(LeaveType leaveType) {
        repository.save(leaveType);
    }

    public List<LeaveType> findAll() {
        return repository.findAll();
    }

    public LeaveType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}