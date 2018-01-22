package com.Resource.model;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    public Person(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Person(){
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
