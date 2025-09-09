package com.practice.controllers;

import com.practice.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/hello")
//    public String sayHelloToEmp() {
//        return "hello";
//    }


    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeId(@PathVariable Long id) {
        return new EmployeeDTO();
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) String sortBy) {
        return "Sorted By: " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(10L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployeeById() {
        return "PUT Request";
    }


}
