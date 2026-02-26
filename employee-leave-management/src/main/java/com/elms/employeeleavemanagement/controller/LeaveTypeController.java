package com.elms.employeeleavemanagement.controller;

import com.elms.employeeleavemanagement.model.LeaveType;
import com.elms.employeeleavemanagement.service.LeaveTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    // Display list of leave types
    @GetMapping("/leaveTypes")
    public String listLeaveTypes(Model model) {
        model.addAttribute("leaveTypes", leaveTypeService.findAll());
        return "leave-type-list";
    }

    // Show form to add new leave type
    @GetMapping("/addLeaveType")
    public String showAddForm(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        return "add-leave-type";
    }

    // Save leave type
    @PostMapping("/saveLeaveType")
    public String saveLeaveType(@ModelAttribute LeaveType leaveType) {
        leaveTypeService.save(leaveType);
        return "redirect:/leaveTypes";
    }
}