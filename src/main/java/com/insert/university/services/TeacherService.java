package com.insert.university.services;

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

    public void addCourseToTeacher(Long teacherId, Long courseId) {
        TeacherEntity teacher = repository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));
        CourseEntity course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Lesson not found"));
        teacher.getCourseEntityList().add(course);
        repository.save(teacher);
    }

    public void removeCourseFromTeacher(Long teacherId, Long courseId) {
        TeacherEntity teacher = repository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));
        CourseEntity course = teacher.getCourseEntityList().stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The course was not found in the teacher's list"));
        teacher.getCourseEntityList().remove(course);
        repository.save(teacher);
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
}
