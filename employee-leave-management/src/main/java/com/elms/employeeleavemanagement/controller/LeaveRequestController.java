package com.elms.employeeleavemanagement.controller;

import com.elms.employeeleavemanagement.model.LeaveRequest;
import com.elms.employeeleavemanagement.service.EmployeeService;
import com.elms.employeeleavemanagement.service.LeaveRequestService;
import com.elms.employeeleavemanagement.service.LeaveTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LeaveRequestController {

    private final LeaveRequestService leaveService;
    private final EmployeeService employeeService;
    private final LeaveTypeService leaveTypeService;

    public LeaveRequestController(LeaveRequestService leaveService,
                                  EmployeeService employeeService,
                                  LeaveTypeService leaveTypeService) {
        this.leaveService = leaveService;
        this.employeeService = employeeService;
        this.leaveTypeService = leaveTypeService;
    }

    @GetMapping("/applyLeave")
    public String showForm(Model model) {
        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("leaveTypes", leaveTypeService.findAll());
        return "apply-leave";
    }

    @PostMapping("/saveLeave")
    public String apply(@ModelAttribute LeaveRequest leaveRequest) {
        leaveService.applyLeave(leaveRequest);
        return "redirect:/leaveRequests";
    }

    @GetMapping("/leaveRequests")
    public String list(Model model) {
        model.addAttribute("requests", leaveService.findAll());
        return "leave-request-list";
    }

    @GetMapping("/approve/{id}")
    public String approve(@PathVariable Integer id) {
        leaveService.updateStatus(id, "Approved");
        return "redirect:/leaveRequests";
    }

    @GetMapping("/reject/{id}")
    public String reject(@PathVariable Integer id) {
        leaveService.updateStatus(id, "Rejected");
        return "redirect:/leaveRequests";
    }
}