package com.jr.restapi.repositories;

import com.jr.restapi.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
}
