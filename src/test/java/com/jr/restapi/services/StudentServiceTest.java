package com.jr.restapi.services;

import com.jr.restapi.dtos.StudentGetDto;
import com.jr.restapi.dtos.StudentPostDto;
import com.jr.restapi.entities.StudentEntity;
import com.jr.restapi.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void shouldAddStudentSuccessfullyGivenProperStudent(){
        StudentPostDto studentPostDto = new StudentPostDto();
        studentPostDto.setFirstName("Leo");
        studentPostDto.setPassword("123");

        StudentEntity mockStudentEntity = new StudentEntity();
        mockStudentEntity.setFirstName("Leo");
        mockStudentEntity.setPassword("123");
        UUID studentId = UUID.randomUUID();
        mockStudentEntity.setId(studentId);

        when(studentRepository.save(any())).thenReturn(mockStudentEntity);

        StudentGetDto studentGetDto = studentService.createStudent(studentPostDto);

        assertEquals(studentGetDto.getFirstName(), "Leo");
        assertEquals(studentGetDto.getId(), studentId.toString());
    }
}
