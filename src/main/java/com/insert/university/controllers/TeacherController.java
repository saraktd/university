package com.insert.university.controllers;

import com.insert.university.common.StudentDto;
import com.insert.university.common.TeacherDto;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.services.TeacherService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController<TeacherEntity, TeacherDto, TeacherService> {
@Autowired
  TeacherService teacherService;
        @PostMapping("/create")
        public TeacherDto createTeacher(@RequestBody TeacherDto dto) {

            TeacherEntity teacherEntity = service.createAccount(dto.getName(), dto.getFamily(), dto.getNationalCode());

            return converter.convertEtoD(teacherEntity);
        }
            @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteAccount(id);
    }


}
