package com.insert.university.services;

import com.insert.university.common.CourseDto;
import com.insert.university.converter.CourseConverter;
import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.repositories.CourseRepository;
import com.insert.university.repositories.StudentRepository;
import com.insert.university.repositories.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService extends BaseService<CourseEntity, CourseRepository> {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseConverter courseConverter;


    public void enrollStudentInCourse(StudentEntity student, CourseEntity course) {
        if (!student.getCourses().contains(course)) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            repository.save(course);
            studentRepository.save(student);
        }
    }

    public void dropCourseFromStudent(StudentEntity student, CourseEntity course) {
        if (student.getCourses().contains(course)) {
            student.getCourses().remove(course);
        }
        if (course.getStudents().contains(student)) {
            course.getStudents().remove(student);
        }

        repository.save(course);
        studentRepository.save(student);
    }

    public CourseDto getCourseById(Long id) throws Exception {
        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new Exception("Course not found with id: " + id));
        CourseDto courseDto=new CourseDto();
        courseDto=courseConverter.convertEtoD(course);
        return courseDto ;
    }


}

