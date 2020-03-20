package com.example.demo.service.impl;

import com.example.demo.pojo.Student;
import com.example.demo.dao.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired(required=false)
    private StudentRepository studentRepository;


    @Override
    public List<Student> selectAllStudents() {
        System.out.println("测试");
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public String addIntoStudents(Student student) {
        studentRepository.save(student);
        return "操作成功";
    }

    @Override
    public String updateStudents(Student student) {
        this.studentRepository.save(student);
        return "操作成功";
    }

    @Override
    public String deleteFromStudents(Integer id) {
        studentRepository.deleteById(id);
        return "操作成功";
    }
}
