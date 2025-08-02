package com.practice.controller;

import com.practice.dto.StudentDto;
import com.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }


}
