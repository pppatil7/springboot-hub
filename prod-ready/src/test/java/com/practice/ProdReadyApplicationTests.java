package com.practice;

import com.practice.clients.EmployeeClient;
import com.practice.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;

    @Test
    void getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeClient.getAllEmployee();
        System.out.println(employeeDtoList);
    }

    @Test
    void getEmployeeById() {
        EmployeeDto employeeDto = employeeClient.getEmployeeById(1L);
        System.out.println(employeeDto);
    }

    @Test
    void createNewEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(null, "john", "john@co.in", 21,
                "USER", 90000.0, LocalDate.of(2025, 9, 19), true);
        EmployeeDto savedEmployeeDto = employeeClient.createNewEmployee(employeeDto);
        System.out.println(savedEmployeeDto);
    }

}
