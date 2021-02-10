package com.jr.restapi.controllers;

import com.jr.restapi.dtos.StudentGetDto;
import com.jr.restapi.dtos.StudentPostDto;
import com.jr.restapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentGetDto> createStudent(@RequestBody StudentPostDto studentPostDto){
        StudentGetDto studentGetDto = studentService.createStudent(studentPostDto);

        return ResponseEntity.ok(studentGetDto);
    }
}
