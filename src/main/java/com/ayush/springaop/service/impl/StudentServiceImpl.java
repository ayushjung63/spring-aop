package com.ayush.springaop.service.impl;

import com.ayush.springaop.model.Student;
import com.ayush.springaop.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentList() {
        List<Student> students = Arrays.asList(
                Student.builder().id(1L).fullName("A").build(),
                Student.builder().id(2L).fullName("B").build(),
                Student.builder().id(3L).fullName("C").build(),
                Student.builder().id(4L).fullName("D").build()
        );
        return students;
    }
}
