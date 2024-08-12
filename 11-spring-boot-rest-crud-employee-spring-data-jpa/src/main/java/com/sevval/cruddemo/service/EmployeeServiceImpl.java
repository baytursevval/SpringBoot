package com.sevval.cruddemo.service;

import com.sevval.cruddemo.dao.EmployeeRepository;
import com.sevval.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee=null;

        if(result.isPresent()){
            theEmployee=result.get();
        }
        else {
            throw new RuntimeException("didnt find employee id - "+ id);
        }

        return theEmployee;
    }
    //belirli bir değerin mevcut olup olmadığını görmek için optional kullan
    //null olup olmadğını açıkça kontrol etmek zorunda kalmadan verileri almak için temel yaklaşım
    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
