package com.blog.postmanrunner.controller;

import com.blog.postmanrunner.handler.HandlerInstance;
import com.blog.postmanrunner.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudent {

    @Autowired
    private HandlerInstance handlerInstance;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        Student newStudent = handlerInstance.createStudent(student.getFirstname(), student.getLastname(), student.getPhoneNumber(), student.getDepartment());
        handlerInstance.studentList.add(newStudent);
        return newStudent;
    }
}
