package com.example.practice15.repositories;

import com.example.practice15.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findByCreationDateBetween(LocalDate from, LocalDate to);
}
