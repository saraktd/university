package com.insert.university.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
public class CourseEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "unit")
    private Integer unit;

    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}
