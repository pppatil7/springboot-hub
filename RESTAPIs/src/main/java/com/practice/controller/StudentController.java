package com.practice.controller;

import com.practice.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent() {
        return null;
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById() {
        return null;
    }


}
