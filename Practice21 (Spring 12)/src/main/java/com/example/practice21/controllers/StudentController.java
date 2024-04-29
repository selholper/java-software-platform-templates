package com.example.practice21.controllers;

import com.example.practice21.models.Student;
import com.example.practice21.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("student/id={studentId}")
    public @ResponseBody Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("student/firstName={firstName}")
    public @ResponseBody List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    @GetMapping("student/lastName={lastName}")
    public @ResponseBody List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @GetMapping("student/middleName={middleName}")
    public @ResponseBody List<Student> getStudentsByMiddleName(@PathVariable String middleName) {
        return studentService.getStudentsByMiddleName(middleName);
    }

    @GetMapping("student/universityId={universityId}")
    public @ResponseBody List<Student> getStudentsByUniversityId(@PathVariable Long universityId) {
        return studentService.getStudentsByUniversityId(universityId);
    }
}
