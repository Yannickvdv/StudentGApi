package com.Resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import com.Resource.model.Student;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table( name="assignment" )
public class Assignment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private double grade;

    @JsonIgnore
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "studentID", nullable = false)
    private Student student;

    public Assignment(long id, String name, Double grade, Student student){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.student = student;
    }
    public Assignment(){
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }
}