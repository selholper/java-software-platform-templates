package com.example.practice15.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.practice15.models.Student;
import org.springframework.stereotype.Service;
import com.example.practice15.repositories.StudentRepository;

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
}
