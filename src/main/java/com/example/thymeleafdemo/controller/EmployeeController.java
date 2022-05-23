package com.example.thymeleafdemo.controller;

import java.util.List;

import com.example.thymeleafdemo.entity.Employee;
import com.example.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employees = employeeService.findAll();
        theModel.addAttribute("employees", employees);

        return "list-employees";
    }
    @GetMapping("/addEmployee")
    public String showAddForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("updateForm")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }
    @GetMapping("delete")
    public String deleteEmployeeById(@RequestParam("id") int id, Model model) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
