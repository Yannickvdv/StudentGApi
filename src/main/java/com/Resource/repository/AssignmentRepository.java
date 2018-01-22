package com.Resource.repository;

import com.Resource.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository  extends JpaRepository<Assignment, Long>  {
    List<Assignment> findByStudent_Id(Long studentID);
}
