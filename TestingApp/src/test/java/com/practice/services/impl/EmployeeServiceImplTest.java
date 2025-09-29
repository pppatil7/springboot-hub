package com.practice.services.impl;

import com.practice.dto.EmployeeDTO;
import com.practice.entities.Employee;
import com.practice.repositories.EmployeeRepository;
import com.practice.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {


    @Mock
    private EmployeeRepository employeeRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;


    @Test
    void testGetEmployeeById_WhenEmployeeIdIsPresent_ThenReturnEmployeeDto() {


        //assign
        Long id = 1L;
        Employee mockEmployee = Employee.builder()
                .id(id)
                .name("john")
                .email("john@co.in")
                .salary(90000.0)
                .build();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee)); //stubbing

        //act
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(1L);

        //assert
        assertThat(employeeDTO.getId()).isEqualTo(id);
        assertThat(employeeDTO.getEmail()).isEqualTo(mockEmployee.getEmail());


    }


}