package com.insert.university.converter;

import com.insert.university.common.CourseDto;
import com.insert.university.common.TeacherDto;
import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.TeacherEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public class TeacherConverter extends BaseConverter<TeacherEntity,TeacherDto>{

    @Override
    public TeacherEntity convertDtoE(TeacherDto d) {
        TeacherEntity newTeacherEntity = new TeacherEntity();
        newTeacherEntity.setId(d.getId());
        newTeacherEntity.setNationalCode(d.getNationalCode());
        newTeacherEntity.setName(d.getName());
        newTeacherEntity.setFamily(d.getFamily());
        newTeacherEntity.setVersion(d.getVersion());
        return newTeacherEntity;
    }

    @Override
    public  TeacherDto convertEtoD( TeacherEntity e) {
        TeacherDto newTeacherDto = new TeacherDto();
        newTeacherDto.setId(e.getId());
        newTeacherDto.setName(e.getName());
        newTeacherDto.setFamily(e.getFamily());
        newTeacherDto.setNationalCode(e.getNationalCode());
        newTeacherDto.setVersion(e.getVersion());
        return newTeacherDto;
    }
}
