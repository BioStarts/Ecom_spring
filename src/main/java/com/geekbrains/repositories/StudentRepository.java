package com.geekbrains.repositories;

import com.geekbrains.entities.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student(1L, "Bob", "Bobson"));
        students.add(new Student(2L, "John", "Johnson"));
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    public Optional<Student> findOneById(Long id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public boolean existById(Long id) {
        return students.stream().anyMatch(s -> s.getId().equals(id));
    }

    public void insert(Student student) {
        if (existById(student.getId())) {
            throw new RuntimeException("Student with id: " + student.getId() + " is already exists");
        }
        students.add(student);
    }
}