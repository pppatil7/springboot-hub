package com.practice.clients.impl;

import com.practice.clients.EmployeeClient;
import com.practice.dto.EmployeeDto;
import com.practice.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDto> getAllEmployee() {
        log.trace("Tying to retrieve all employees in getAllEmployees");
        try {
            log.info("Attempting to call the restClient method in getAllEmployees");
            List<EmployeeDto> employeeDtoList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved employees list in getAllEmployees {}", employeeDtoList.toString());
            return employeeDtoList;
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        log.trace("Tying to retrieve all employees in getAllEmployees with id: {}", employeeId);
        try {
            EmployeeDto employeeDto = restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDto;
        } catch (Exception e) {
            log.error("Exception occurred in getEmployeeById", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        try {
            ResponseEntity<EmployeeDto> savedEmployeeDto = restClient.post()
                    .uri("employees")
                    .body(employeeDto)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            return savedEmployeeDto.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
