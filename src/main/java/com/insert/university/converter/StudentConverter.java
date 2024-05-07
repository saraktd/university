package com.insert.university.converter;

import com.insert.university.common.StudentDto;
import com.insert.university.model.entities.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentConverter extends BaseConverter<StudentEntity, StudentDto>{
}
