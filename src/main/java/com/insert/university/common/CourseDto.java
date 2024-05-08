package com.insert.university.common;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@ToString
public class CourseDto extends BaseDto{
    private String name;
    private Integer unit;



}
