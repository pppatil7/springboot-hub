package com.practice.controllers;

import com.practice.dto.EmployeeDTO;
import com.practice.entities.Employee;
import com.practice.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    @GetMapping(path = "/hello")
//    public String sayHelloToEmp() {
//        return "hello";
//    }


    @GetMapping("/{id}")
    public Employee getEmployeeId(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployeeById() {
        return "PUT Request";
    }


}
