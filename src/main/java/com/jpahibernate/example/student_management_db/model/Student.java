package com.jpahibernate.example.student_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // it represents that this class is entity or model class which is directly creating the database table or schema
@Table(name="student") // it will create a table inside database
public class Student {

    @Id // it is the primary key of the table - it will be unique and it is not null
    @Column(name="id") // it will create a column inside database table
    private int id;

    @Column(name = "student_name", nullable = false) // nullable = false - it cannot contain null value
    private String name;

    @Column(name = "email", nullable = false, unique = true) // unique=true - it cannot contain duplicated value
    private String email;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name="mobile", nullable = false)
    private String mobile; //+91-7828888888

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
