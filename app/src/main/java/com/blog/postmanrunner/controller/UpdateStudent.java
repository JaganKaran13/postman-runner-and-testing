package com.blog.postmanrunner.controller;

import com.blog.postmanrunner.handler.HandlerInstance;
import com.blog.postmanrunner.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudent {
    @Autowired
    private HandlerInstance handlerInstance;

    @Autowired
    private GetStudent getStudentController;

    @PutMapping("/student/{id}")
    public Student updateStudent(
            @PathVariable("id") int studentId,
            @RequestBody Student student) {
        Student studentDetails = getStudentController.getStudent(studentId);
        if (studentDetails != null) {
            handlerInstance.studentList.remove(studentDetails);
            Student newStudent = handlerInstance.createStudent(student.getFirstname(), student.getLastname(), student.getPhoneNumber(), student.getDepartment());
            handlerInstance.studentList.add(newStudent);
            return newStudent;
        }
        return null;
    }
}
