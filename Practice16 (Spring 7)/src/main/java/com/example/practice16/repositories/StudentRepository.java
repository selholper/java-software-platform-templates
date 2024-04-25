package com.example.practice16.repositories;

import com.example.practice16.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    @Transactional
    void deleteByFirstName(String firstName);
    List<Student> getStudentsByUniversityId(Long universityId);
}
