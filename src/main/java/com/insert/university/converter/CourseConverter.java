package com.insert.university.converter;

import com.insert.university.common.CourseDto;
import com.insert.university.model.entities.CourseEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public class CourseConverter extends BaseConverter<CourseEntity,CourseDto>{
}
