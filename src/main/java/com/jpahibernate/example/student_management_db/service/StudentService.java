package com.jpahibernate.example.student_management_db.service;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains the business logic
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student Saved Successfully!";
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getStudentById(int id){
       Optional<Student> studentOptional = studentRepository.findById(id);
       if(studentOptional.isPresent()){
           return studentOptional.get();
       } else{
           return null;
       }
    }

    public String updateStudentUsingPut(int id, Student newStudentRequest){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student existingStudent = getStudentById(id);
        if(existingStudent!=null){
            studentRepository.save(newStudentRequest);
            return "Student updated successfully!";
        } else{
            return "Student not found hence cannot update";
        }
    }

    public String updateStudentUsingPatch(int id, String newEmail){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student existingStudent = getStudentById(id);
        if(existingStudent!=null){
            existingStudent.setEmail(newEmail);
            studentRepository.save(existingStudent);
            return "Student updated successfully!";
        } else{
            return "Student not found hence cannot update";
        }
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id : "+id+" got deleted successfully!";
    }
}
