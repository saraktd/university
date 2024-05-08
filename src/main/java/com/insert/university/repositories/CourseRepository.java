package com.insert.university.repositories;

import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
