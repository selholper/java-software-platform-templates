package com.example.practice16.controllers;

import com.example.practice16.models.Student;
import com.example.practice16.models.University;
import com.example.practice16.services.StudentService;
import com.example.practice16.services.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping("/university/{universityId}/students")
    public @ResponseBody University getUniversityStudent(@PathVariable("universityId") Long universityId) {
        return universityService.getUniversityById(universityId);
    }
}
