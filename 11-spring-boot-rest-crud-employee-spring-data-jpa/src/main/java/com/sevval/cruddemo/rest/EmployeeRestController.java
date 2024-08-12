package com.sevval.cruddemo.rest;

import com.sevval.cruddemo.entity.Employee;
import com.sevval.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService)
    {

        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee emp=employeeService.findById(employeeId);

        if(emp==null){
            throw new RuntimeException("employee id not found - " + employeeId);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        Employee dbEmployee=employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee=employeeService.save(employee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee=employeeService.findById(employeeId);

        if (tempEmployee==null){
            throw new RuntimeException("employee id not found - "+ employeeId);
        }
        employeeService.deleteById(employeeId);

        return "deleted employee id - "+employeeId;
    }
}
