package com.example.practice15.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.practice15.models.University;
import org.springframework.stereotype.Service;
import com.example.practice15.repositories.UniversityRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UniversityService {
    private final UniversityRepository universityRepository;

    public List<University> listAllUniversities() {
        return universityRepository.findAll();
    }

    public List<University> listUniversitiesCreationDateBetween(LocalDate from, LocalDate to) {
        log.info("Listing universities between {} to {}", from, to);
        return universityRepository.findByCreationDateBetween(from, to);
    }

    public void saveUniversity(University university) {
        log.info("Saving university {}", university);
        universityRepository.save(university);
    }

    public void deleteUniversity(Long id) {
        log.info("Deleting university {}", id);
        universityRepository.deleteById(id);
    }
}
