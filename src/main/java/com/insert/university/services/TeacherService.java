package com.insert.university.services;

import com.insert.university.common.StudentDto;
import com.insert.university.common.TeacherDto;
import com.insert.university.converter.TeacherConverter;
import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.repositories.CourseRepository;
import com.insert.university.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class TeacherService extends BaseService<TeacherEntity, TeacherRepository>{

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final TeacherConverter teacherConverter;


    public void addCourseToTeacher(Long courseId, Long teacherId) {
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));
        CourseEntity course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Lesson not found"));
        teacher.getCourses().add(course);
        teacherRepository.save(teacher);
        course.setTeacher(teacher);

    }

    public void removeCourseFromTeacher(Long courseId, Long teacherId) {
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));
        CourseEntity course = teacher.getCourses().stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The course was not found in the teacher's list"));


        if (course.getTeacher() != null && course.getTeacher().equals(teacher)) {
            course.setTeacher(null);
            teacher.getCourses().remove(course);
        }

        teacherRepository.save(teacher);
        courseRepository.save(course);

    }
    public TeacherEntity createAccount(String teacherName, String teacherFamily, String teacherNationalCode ) {
        if (teacherName == null || teacherFamily == null|| teacherNationalCode==null) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }

        TeacherEntity newTeacherEntity = new TeacherEntity();
        newTeacherEntity.setName(teacherName);
        newTeacherEntity.setFamily(teacherFamily);
        newTeacherEntity.setNationalCode(teacherNationalCode);

        teacherRepository.save(newTeacherEntity);

        return newTeacherEntity;
    }
    public void deleteAccount(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        boolean exists = teacherRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("Account with ID: " + id + " does not exist");
        }
        try {
            teacherRepository.deleteById(id);
            System.out.println("The desired user has been successfully deleted");
        } catch (Exception e) {
            System.out.println("error");
        }

    }
    public TeacherDto getTeacherById(Long id) throws Exception {
        TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new Exception("Teacher not found with id: " + id));
        TeacherDto teacherDto=new TeacherDto();
        teacherDto=teacherConverter.convertEtoD(teacher);
        return teacherDto ;
    }

}
