package com.Resource.repository;

import com.Resource.model.Assignment;
import com.Resource.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {
   Student findById(Long studentID);
}
