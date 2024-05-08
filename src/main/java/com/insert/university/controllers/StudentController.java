package com.insert.university.controllers;

import com.insert.university.common.StudentDto;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<StudentEntity, StudentDto, StudentService> {
    @Autowired
    StudentService studentService;
    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto dto) {
        return (StudentDto) converter.convertEtoD(studentService.createAccount(dto.getName(), dto.getFamily(), dto.getNationalCode()));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteAccount(id);
    }
    @GetMapping("/getSumUnits")
        public Long getsumUnits(@RequestBody StudentDto dto){
        return studentService.calculateTotalUnits(dto.getId());
        }

    }




