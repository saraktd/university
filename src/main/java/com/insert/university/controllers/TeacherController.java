package com.insert.university.controllers;

import com.insert.university.common.StudentDto;
import com.insert.university.common.TeacherDto;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.services.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController<TeacherEntity,TeacherDto, TeacherService>{
    @PostMapping("/create")
    public TeacherDto createTeacher(@RequestBody TeacherDto dto) {
        return (TeacherDto) converter.convertEtoD(service.createAccount(dto.getName(), dto.getFamily(), dto.getNationalCode()));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        service.deleteAccount(id);
    }


}
