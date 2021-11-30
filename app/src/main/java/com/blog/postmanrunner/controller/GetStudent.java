package com.blog.postmanrunner.controller;

import com.blog.postmanrunner.handler.HandlerInstance;
import com.blog.postmanrunner.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStudent {

    @Autowired
    private HandlerInstance handlerInstance;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return handlerInstance.studentList;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int studentId) {
        return handlerInstance.studentList.stream()
                .filter(student -> student.getStudentId() == studentId)
                .findAny()
                .orElse(null);
    }
}
