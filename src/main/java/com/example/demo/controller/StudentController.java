package com.example.demo.controller;

import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/find")
    @ResponseBody
    public Object findAllStudents()
    {
        return studentService.selectAllStudents();
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addIntoStudents(Integer id,String name,Integer age,Double score)
    {
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setScore(score);
        return studentService.addIntoStudents(student);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateStudents(Integer id,String name,Integer age,Double score)
    {
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setScore(score);
        return studentService.updateStudents(student);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteFromStudents(Integer id)
    {
        return studentService.deleteFromStudents(id);
    }

}
