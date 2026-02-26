package com.elms.employeeleavemanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveTypeId;

    private String leaveName;
    private Integer maxDaysAllowed;

    @OneToMany(mappedBy = "leaveType")
    private List<LeaveRequest> leaveRequests;

    public LeaveType() {}

    // Getters and Setters
}