package com.practice.services;

import com.practice.dto.EmployeeDTO;
import com.practice.entities.Employee;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public interface EmployeeService {


    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee);

    EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO);

    boolean deleteEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();


}
