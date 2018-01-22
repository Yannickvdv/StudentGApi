package com.Resource.controller;

import com.Resource.model.Assignment;
import com.Resource.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class AssignmentController {

    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping("/students/{id}")
    public List<Assignment> getAllAssignments(@PathVariable(value = "id") Long studentId) {

        return assignmentRepository.findByStudent_Id(studentId);
    }

    @PostMapping("/assignments/{id}")
    public Assignment createAssignment(@Valid @RequestBody Assignment Assignment) {
        return assignmentRepository.save(Assignment);
    }

    @DeleteMapping("/assignment/{id}")
    public ResponseEntity<Assignment> deleteAssignment(@PathVariable(value = "id") Long assignmentId) {

        Assignment assignment = assignmentRepository.findOne(assignmentId);
        if(assignment == null) {
            return ResponseEntity.notFound().build();
        }

        assignmentRepository.delete(assignment);
        return ResponseEntity.ok().build();
    }



}
