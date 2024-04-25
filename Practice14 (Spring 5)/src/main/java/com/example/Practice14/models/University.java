package com.example.Practice14.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class University {
    String name;
    LocalDate creationDate;
}
