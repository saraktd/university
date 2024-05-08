package com.insert.university.controllers;

import com.insert.university.common.CourseDto;
import com.insert.university.common.StudentDto;
import com.insert.university.converter.StudentConverter;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<StudentEntity, StudentDto, StudentService> {
    private final StudentService studentService;
    private final StudentConverter studentConverter;

    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        StudentEntity studentEntity = studentService.createAccount(studentDto.getName(), studentDto.getFamily(), studentDto.getNationalCode());
        return studentConverter.convertEtoD(studentEntity);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {

        studentService.deleteAccount(id);
    }
  @Transactional
    @PostMapping("/{studentId}/courses/{courseId}/{teacherId}")
    public ResponseEntity<?> addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId,@PathVariable Long teacherId) {
        studentService.addCourseToStudent(studentId, courseId,teacherId);
        return ResponseEntity.ok().build();
    }

}


