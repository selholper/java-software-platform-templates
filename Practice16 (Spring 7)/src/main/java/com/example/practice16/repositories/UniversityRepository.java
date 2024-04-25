package com.example.practice16.repositories;

import com.example.practice16.models.Student;
import com.example.practice16.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findByCreationDateBetween(LocalDate from, LocalDate to);
    University getUniversitiesById(Long id);
}
