package com.example.demo.dao;
import com.example.demo.pojo.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student,Integer> {
}
