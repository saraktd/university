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
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "family")
    private String family;
    @Column(name = "nationalcode")
    private String nationalCode;
    @ManyToMany(mappedBy = "teacherEntityList")
    private List<StudentEntity> studentEntityList;


}
