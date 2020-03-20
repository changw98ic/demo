package com.example.demo.service;

import com.example.demo.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudents();

    String addIntoStudents(Student student);

    String updateStudents(Student student);

    String deleteFromStudents(Integer id);
}
