package com.example.practice17.services;

import com.example.practice17.models.Student;
import com.example.practice17.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> listStudents(String firstName) {
        if (firstName == null) {
            return studentRepository.findAll();
        }

        return studentRepository.findByFirstName(firstName);
    }

    public void saveStudent(Student student) {
        log.info("Saving student {}", student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        log.info("Deleting student {}", id);
        studentRepository.deleteById(id);
    }

    public void deleteStudentByFirstName(String firstName) {
        log.info("Deleting student by firstName {}", firstName);
        studentRepository.deleteByFirstName(firstName);
    }

    public Student getStudentById(Long id) {
        log.info("Getting student {}", id);
        return studentRepository.getStudentsById(id);
    }

    public List<Student> getStudentsByFirstName(String firstName) {
        log.info("Getting student by firstName {}", firstName);
        return studentRepository.getStudentsByFirstName(firstName);
    }

    public List<Student> getStudentsByLastName(String lastName) {
        log.info("Getting student by lastName {}", lastName);
        return studentRepository.getStudentsByLastName(lastName);
    }

    public List<Student> getStudentsByMiddleName(String middleName) {
        log.info("Getting student by middleName {}", middleName);
        return studentRepository.getStudentByMiddleName(middleName);
    }

    public List<Student> getStudentsByUniversityId(Long universityId) {
        log.info("Getting students by universityId {}", universityId);
        return studentRepository.getStudentsByUniversityId(universityId);
    }
}
