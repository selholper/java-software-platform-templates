package com.example.practice22.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.practice22.models.University;
import org.springframework.stereotype.Service;
import com.example.practice22.repositories.UniversityRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UniversityService {

    private final UniversityRepository universityRepository;
    private final EmailService emailService;



    public List<University> listAllUniversities() {
        log.info("Listing all universities");
        return universityRepository.findAll();
    }

    public List<University> listUniversitiesCreationDateBetween(LocalDate from, LocalDate to) {
        log.info("Listing universities between {} to {}", from, to);
        return universityRepository.findByCreationDateBetween(from, to);
    }

    @Transactional
    public void saveUniversity(University university) {
        log.info("Saving university {}", university);
        universityRepository.save(university);
        emailService.sendEmail(System.getenv("USER_EMAIL"), "Saving a university object",
            "Dear user, we save a new " + university
            + " object in our database.\nBest wishes, SpringApplication.");
    }

    public void deleteUniversity(Long id) {
        log.info("Deleting university {}", id);
        universityRepository.deleteById(id);
    }

    public void deleteUniversitiesByName(String name) {
        log.info("Deleting university by name {}", name);
        universityRepository.deleteByName(name);
    }

    public University getUniversityById(Long universityId) {
        log.info("Getting university by university_id {}", universityId);
        return universityRepository.getUniversitiesById(universityId);
    }

    public List<University> getUniversitiesByName(String name) {
        log.info("Getting universities by name {}", name);
        return universityRepository.getUniversitiesByName(name);
    }

    public List<University> getUniversitiesByYear(int year) {
        log.info("Getting universities by year {}", year);
        return universityRepository.getUniversitiesByCreationDateYear(year);
    }
}
