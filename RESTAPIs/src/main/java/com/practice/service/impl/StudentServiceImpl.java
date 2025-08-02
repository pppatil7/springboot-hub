package com.practice.service.impl;

import com.practice.dto.AddStudentRequestDto;
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
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found with id: " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exist by id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found with id: " + id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
