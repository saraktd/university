package com.insert.university.common;

import com.insert.university.model.entities.CourseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
@ToString
public class StudentDto extends PersonDto{


}
