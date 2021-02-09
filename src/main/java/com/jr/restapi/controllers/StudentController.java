package com.jr.restapi.controllers;

import com.jr.restapi.dtos.StudentPostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentPostDto studentPostDto){
        System.out.println(studentPostDto);
        return ResponseEntity.ok("Hello world");
    }
}
