package com.insert.university.controllers;

import com.insert.university.common.CourseDto;
import com.insert.university.common.TeacherDto;
import com.insert.university.converter.CourseConverter;
import com.insert.university.converter.TeacherConverter;
import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.repositories.CourseRepository;
import com.insert.university.services.CourseService;
import com.insert.university.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController extends BaseController<CourseEntity, CourseDto, CourseService> {

    private final CourseService courseService;
    private final CourseConverter courseConverter;
    private final CourseRepository courseRepository;



    @GetMapping("/find/{id}")
    public CourseDto getCourseById(@PathVariable Long id) throws Exception {
      return  courseService.getCourseById(id);
    }
}