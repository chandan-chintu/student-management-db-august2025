package com.jpahibernate.example.student_management_db.controller;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    // @RequestBody- it is used to take the inputs in the form of json objects(used for complete class)

    // debugging - helps to track down the application line by line to get the complete flow of the application
    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return response;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList= studentService.getAllStudents();
        return studentList;
    }

    // @PathVariable - input is taken in the url path
    @GetMapping("/findById/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return student;
    }

}
