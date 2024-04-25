package com.example.practice15.repositories;

import com.example.practice15.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    @Transactional
    void deleteByFirstName(String firstName);
}
