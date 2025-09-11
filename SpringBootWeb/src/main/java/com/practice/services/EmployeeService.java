package com.practice.services;

import com.practice.dto.EmployeeDTO;
import com.practice.entities.Employee;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id: " + id));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = employees.stream()
                .map((employee) -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
        return employeeDTOList;

    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        Employee employee = modelMapper.map(inputEmployee, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        isExistsById(id);
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setId(id);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public void isExistsById(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Employee Not Found with id: " + id);
    }

    public boolean deleteEmployeeById(Long id) {
        isExistsById(id);
        employeeRepository.deleteById(id);
        return true;
    }


}
