package com.example.Practice14.services;

import com.example.Practice14.models.University;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {

    List<University> universities;

    public UniversityService() {
        universities = new ArrayList<>();
    }

    public boolean add(University university) {
        return universities.add(university);
    }

    public boolean remove(University university) {
        return universities.remove(university);
    }

    public List<University> getAll() {
        return universities;
    }
}
