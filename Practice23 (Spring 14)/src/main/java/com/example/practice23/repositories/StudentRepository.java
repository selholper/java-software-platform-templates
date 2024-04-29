package com.example.practice23.repositories;

import com.example.practice23.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    void deleteByFirstName(String firstName);
    Student getStudentsById(Long id);
    List<Student> getStudentsByFirstName(String firstName);
    List<Student> getStudentsByLastName(String lastName);
    List<Student> getStudentByMiddleName(String middleName);
    List<Student> getStudentsByUniversityId(Long universityId);

}
