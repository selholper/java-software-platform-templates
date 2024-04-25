package com.example.Practice14.services;

import com.example.Practice14.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public boolean add(Student student) {
        return students.add(student);
    }

    public boolean remove(Student student) {
        return students.remove(student);
    }

    public List<Student> getAll() {
        return students;
    }
}
