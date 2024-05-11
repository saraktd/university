package com.insert.university.converter;

import com.insert.university.common.CourseDto;
import com.insert.university.model.entities.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
@RequiredArgsConstructor
public class CourseConverter extends BaseConverter<CourseEntity, CourseDto> {
    @Override
    public  CourseEntity convertDtoE(CourseDto d) {
        CourseEntity newCourseEntity = new CourseEntity();
        newCourseEntity.setId(d.getId());
        newCourseEntity.setName(d.getName());
        newCourseEntity.setUnit(d.getUnit());
        newCourseEntity.setVersion(d.getVersion());
        return newCourseEntity;
    }

@Override
     public  CourseDto convertEtoD( CourseEntity e) {
    CourseDto newCourseDto = new CourseDto();
    newCourseDto.setId(e.getId());
    newCourseDto.setName(e.getName());
    newCourseDto.setUnit(e.getUnit());
    newCourseDto.setVersion(e.getVersion());
    return newCourseDto;
}
}