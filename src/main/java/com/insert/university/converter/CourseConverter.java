package com.insert.university.converter;

import com.insert.university.common.CourseDto;
import com.insert.university.model.entities.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseConverter extends BaseConverter<CourseEntity, CourseDto>{
}
