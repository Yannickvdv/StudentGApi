package com.Resource.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person{


    @OneToMany(mappedBy="student")
    @Column
    private List<Assignment> assignments = new ArrayList<>();

    public List<Assignment> getAssignments() { return assignments; }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

}