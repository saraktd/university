package com.insert.university.controllers;

import com.insert.university.common.StudentDto;
import com.insert.university.common.TeacherDto;
import com.insert.university.converter.TeacherConverter;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.repositories.TeacherRepository;
import com.insert.university.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
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
    @Transactional
    @PostMapping("/addC/{courseId}/{teacherId}")
    public ResponseEntity<?> addCourseToTeacher(@PathVariable Long courseId, @PathVariable Long teacherId) {
        teacherService.addCourseToTeacher(courseId,teacherId);
        return ResponseEntity.ok().build();
    }
    @Transactional
    @DeleteMapping("/removeC/{teacherId}/{courseId}")
    public ResponseEntity<?> removeCourseToStudent(@PathVariable Long courseId, @PathVariable Long teacherId) {
        teacherService.removeCourseFromTeacher(teacherId, courseId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/find/{id}")
    public TeacherDto getCourseById(@PathVariable Long id) throws Exception {
        return  teacherService.getTeacherById(id);
    }
}


