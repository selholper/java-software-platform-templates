package com.example.practice23.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @Override
    public String toString() {
        return "Student(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName="
                + this.getLastName() + ", middleName=" + this.getMiddleName() + ", university=\""
                + this.getUniversity().getName() + "\")";
    }
}
