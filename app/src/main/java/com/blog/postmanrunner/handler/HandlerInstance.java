package com.blog.postmanrunner.handler;

import com.blog.postmanrunner.models.Department;
import com.blog.postmanrunner.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandlerInstance {

    public final List<Student> studentList = new ArrayList<>();

    public Student createStudent(
            String firstName,
            String lastname,
            String phoneNumber,
            List<Department> department
    ) {
        Student student = new Student();
        if (studentList.isEmpty()) {
            student.setStudentId(1);
        } else {
            student.setStudentId(studentList.size() + 1);
        }
        student.setFirstname(firstName);
        student.setLastname(lastname);
        student.setPhoneNumber(phoneNumber);
        this.setDepartment(department, student);
        return student;
    }

    private void setDepartment(List<Department> department, Student student) {

        List<Department> departmentList = new ArrayList<>();
        for (Department departmentFromRequest: department) {
            Department departmentDetails = new Department();
            switch (departmentFromRequest.getDepartmentId()) {
                case 1:
                    departmentDetails.setDepartmentId(departmentFromRequest.getDepartmentId());
                    departmentDetails.setDepartment("Computer Science");
                    departmentDetails.setSection("A");
                    departmentDetails.setHeadOfDepartment("Abdul");
                    departmentList.add(departmentDetails);
                    student.setDepartment(departmentList);
                    break;
                case 2:
                    departmentDetails.setDepartmentId(departmentFromRequest.getDepartmentId());
                    departmentDetails.setDepartment("Computer Science");
                    departmentDetails.setSection("B");
                    departmentDetails.setHeadOfDepartment("Shiva");
                    departmentList.add(departmentDetails);
                    student.setDepartment(departmentList);
                    break;
                case 3:
                    departmentDetails.setDepartmentId(departmentFromRequest.getDepartmentId());
                    departmentDetails.setDepartment("Information");
                    departmentDetails.setSection("A");
                    departmentDetails.setHeadOfDepartment("Joseph");
                    departmentList.add(departmentDetails);
                    student.setDepartment(departmentList);
                    break;
                default:
                    student.setDepartment(department);
        }
        }
    }
}
