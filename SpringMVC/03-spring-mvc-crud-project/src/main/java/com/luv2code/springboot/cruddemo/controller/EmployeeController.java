package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //since only one constructor, @autowired is optional
    public EmployeeController(EmployeeService theemployeeService){
        employeeService=theemployeeService;
    }

    @GetMapping("/list")
    public String listEmp(Model model){

        List<Employee> employees=employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Employee emp=new Employee();

        model.addAttribute("employee", emp);

        return "employees/add-employee";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
