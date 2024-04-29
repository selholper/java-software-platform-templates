package com.example.practice21.repositories;

import com.example.practice21.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {

    List<University> findByCreationDateBetween(LocalDate from, LocalDate to);
    void deleteByName(String name);
    University getUniversitiesById(Long id);
    List<University> getUniversitiesByName(String name);
    @Query("SELECT u FROM University u WHERE YEAR(u.creationDate) = :year")
    List<University> getUniversitiesByCreationDateYear(@Param("year") int year);
}
