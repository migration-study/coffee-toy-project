package com.example.domain;

public interface CourseRepository {
    int save(Course course);

    Course findById(Long id);
}
