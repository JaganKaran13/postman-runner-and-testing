package com.blog.postmanrunner.models;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int studentId;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private List<Department> department;
}
