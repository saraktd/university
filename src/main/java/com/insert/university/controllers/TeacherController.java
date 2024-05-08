package com.insert.university.controllers;

import com.insert.university.common.TeacherDto;
import com.insert.university.converter.TeacherConverter;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController extends BaseController<TeacherEntity, TeacherDto, TeacherService> {

 private final TeacherService teacherService;
 private final TeacherConverter teacherConverter;


    @PostMapping("/create")
    public TeacherDto createTeacher(@RequestBody TeacherDto dto) {
        TeacherEntity teacherEntity = teacherService.createAccount(dto.getName(), dto.getFamily(), dto.getNationalCode());
        return teacherConverter.convertEtoD(teacherEntity);
    }

        @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {

        teacherService.deleteAccount(id);
    }


}
