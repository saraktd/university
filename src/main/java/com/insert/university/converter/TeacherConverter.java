package com.insert.university.converter;

import com.insert.university.common.TeacherDto;
import com.insert.university.model.entities.TeacherEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherConverter extends BaseConverter<TeacherEntity, TeacherDto> {
}
