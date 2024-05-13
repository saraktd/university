package com.insert.university.converter;

import com.insert.university.common.CourseDto;
import com.insert.university.common.StudentDto;
import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public class StudentConverter extends BaseConverter <StudentEntity,StudentDto>{
    @Override
    public StudentEntity convertDtoE(StudentDto d) {
        StudentEntity newStudentEntity = new StudentEntity();
        newStudentEntity.setId(d.getId());
        newStudentEntity.setName(d.getName());
        newStudentEntity.setFamily(d.getFamily());
        newStudentEntity.setNationalCode(d.getNationalCode());
        newStudentEntity.setVersion(d.getVersion());
        return newStudentEntity;
    }

    @Override
    public  StudentDto convertEtoD(StudentEntity e) {
        StudentDto newStudentDto = new StudentDto();
        newStudentDto.setId(e.getId());
        newStudentDto.setName(e.getName());
        newStudentDto.setFamily(e.getFamily());
        newStudentDto.setNationalCode(e.getNationalCode());
        newStudentDto.setVersion(e.getVersion());
        return newStudentDto;
    }

}
