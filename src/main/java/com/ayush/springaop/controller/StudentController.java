package com.ayush.springaop.controller;

import com.ayush.springaop.annotation.LogRequestData;
import com.ayush.springaop.model.Student;
import com.ayush.springaop.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity fetchStudentList(){
        List<Student> studentList =
                studentService.getStudentList();
        return new ResponseEntity(studentList, HttpStatus.OK);
    }

    @LogRequestData
    @GetMapping("/get/{studentId}")
    public ResponseEntity fetchStudentList(@PathVariable("studentId") Long studentId){
       return new ResponseEntity(studentId,HttpStatus.OK);
    }
}
