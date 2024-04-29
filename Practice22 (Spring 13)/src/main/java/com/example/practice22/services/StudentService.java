package com.example.practice22.services;

import com.example.practice22.models.Student;
import com.example.practice22.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final EmailService emailService;

    public List<Student> listAllStudents() {
        log.info("Listing all students");
        return studentRepository.findAll();
    }

    public List<Student> listStudents(String firstName) {
        log.info("Listing all students by first name");
        if (firstName == null) {
            return studentRepository.findAll();
        }

        return studentRepository.findByFirstName(firstName);
    }


    public void saveStudent(Student student) {
        log.info("Saving student {}", student);
        studentRepository.save(student);
        emailService.sendEmail(System.getenv("USER_EMAIL"), "Saving a student object",
            "Dear user, we save a new " + student
                + " object in our database.\nBest wishes, SpringApplication.");
    }

    public void deleteStudent(Long id) {
        log.info("Deleting student {}", id);
        studentRepository.deleteById(id);
    }

    public void deleteStudentsByFirstName(String firstName) {
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
