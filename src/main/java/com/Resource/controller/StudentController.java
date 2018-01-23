package com.Resource.controller;

import com.Resource.repository.StudentRepository;
import com.Resource.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/students/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(value = "id") Long studentId) {
        return studentRepository.findById(studentId);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}
