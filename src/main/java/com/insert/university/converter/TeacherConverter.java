package com.insert.university.converter;

import com.insert.university.common.TeacherDto;
import com.insert.university.model.entities.TeacherEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public class TeacherConverter extends BaseConverter<TeacherEntity,TeacherDto>{

}
