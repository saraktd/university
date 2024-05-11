package com.insert.university.converter;

import com.insert.university.common.StudentDto;
import com.insert.university.model.entities.StudentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public class StudentConverter extends BaseConverter <StudentEntity,StudentDto>{


}
