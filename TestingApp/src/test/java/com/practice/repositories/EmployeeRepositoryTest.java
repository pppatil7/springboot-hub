package com.practice.repositories;

import com.practice.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;


    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .name("john")
                .email("john@co.in")
                .salary(90000.0)
                .build();
    }


    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
        //Arrange, Given
        employeeRepository.save(employee);

        //Act, When
        List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());

        //Assert, Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList() {
        //Arrange, Given
        String email = "invalidEmail@co.in";

        //Act, When
        List<Employee> employeeList = employeeRepository.findByEmail(email);

        //Assert, Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();


    }
}