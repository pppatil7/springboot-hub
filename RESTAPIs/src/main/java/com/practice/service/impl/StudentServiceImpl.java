package com.practice.service.impl;

import com.practice.dto.StudentDto;
import com.practice.entity.Student;
import com.practice.repository.StudentRepository;
import com.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
        return studentDtoList;
    }


    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found with id: " + id));
        return modelMapper.map(student, StudentDto.class);
    }


}
