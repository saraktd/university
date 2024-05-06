package com.insert.university.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "family")
    private String family;
    @Column(name = "nationalcode")
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private Course course;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_teacher",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teacherEntityList;
}
