package com.insert.university.common;

import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class TeacherDto extends PersonDto {

}
