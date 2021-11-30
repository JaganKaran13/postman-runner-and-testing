package com.blog.postmanrunner.controller;

import com.blog.postmanrunner.handler.HandlerInstance;
import com.blog.postmanrunner.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudent {
    @Autowired
    private HandlerInstance handlerInstance;

    @Autowired
    private GetStudent getStudentController;

    @DeleteMapping("/student/{id}")
    public Student deleteStudent(@PathVariable("id") int studentId) {
        Student studentDetails = getStudentController.getStudent(studentId);
        if (studentDetails != null) {
           handlerInstance.studentList.remove(studentDetails);
        }
        return studentDetails;
    }
}
