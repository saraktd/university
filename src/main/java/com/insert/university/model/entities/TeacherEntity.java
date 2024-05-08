package com.insert.university.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "teacher")
public class TeacherEntity extends PersonEntity{
    @ManyToMany(mappedBy = "teacherEntityList")
    private List<StudentEntity> studentEntityList;
    @ManyToMany(mappedBy = "teacherEntityList")
    private List<CourseEntity> courseEntityList;


}
