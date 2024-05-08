package com.insert.university.model.entities;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonEntity extends BaseEntity {
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "family")
    private String family;
    @Column(name = "nationalcode")
    private String nationalCode;
}
