package com.elms.employeeleavemanagement.controller;

import com.elms.employeeleavemanagement.model.Employee;
import com.elms.employeeleavemanagement.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public String list(Model model) {
        model.addAttribute("employees", service.findAll());
        return "employee-list";
    }

    @GetMapping("/addEmployee")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String save(@ModelAttribute Employee employee) {
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/employees";
    }
}