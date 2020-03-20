package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="age")
    private Integer age;
    @Column(name="name")
    private String name;
    @Column(name="score")
    private Double score;
}
