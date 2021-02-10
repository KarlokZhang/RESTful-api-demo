package com.jr.restapi.services;

import com.jr.restapi.dtos.StudentGetDto;
import com.jr.restapi.dtos.StudentPostDto;
import com.jr.restapi.entities.StudentEntity;
import com.jr.restapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentGetDto createStudent(StudentPostDto studentPostDto){
        StudentEntity studentEntity = this.mapPostDtoToEntity(studentPostDto);
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);

        StudentGetDto studentGetDto = this.mapEntityToGetDto(savedStudentEntity);

        return studentGetDto;
    }

    private StudentEntity mapPostDtoToEntity(StudentPostDto studentPostDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentPostDto.getFirstName());
        studentEntity.setPassword(studentPostDto.getPassword());
        return studentEntity;
    }

    private StudentGetDto mapEntityToGetDto(StudentEntity studentEntity){
        StudentGetDto studentGetDto = new StudentGetDto();
        studentGetDto.setId(studentEntity.getId().toString());
        studentGetDto.setFirstName(studentEntity.getFirstName());

        return studentGetDto;
    }
}
