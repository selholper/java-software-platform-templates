package com.example.practice17.controllers;

import com.example.practice17.models.University;
import com.example.practice17.services.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping("/university/{universityId}/students")
    public @ResponseBody University getUniversityStudent(@PathVariable("universityId") Long universityId) {
        return universityService.getUniversityById(universityId);
    }

    @GetMapping("/university/id={universityId}")
    public @ResponseBody University getUniversityByID(@PathVariable("universityId") Long universityId) {
        return universityService.getUniversityById(universityId);
    }

    @GetMapping("/university/name={universityName}")
    public @ResponseBody List<University> getUniversitiesByName(
            @PathVariable("universityName") String universityName) {
        return universityService.getUniversitiesByName(universityName);
    }

    @GetMapping("/university/year={creationDate}")
    public @ResponseBody List<University> getUniversityCreationDateYear(
            @PathVariable("creationDate") int year) {
        return universityService.getUniversitiesByYear(year);
    }
}