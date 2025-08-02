package com.practice.service;

import com.practice.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
