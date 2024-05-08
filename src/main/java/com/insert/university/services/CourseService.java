package com.insert.university.services;

import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.repositories.CourseRepository;
import com.insert.university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends BaseService<CourseEntity, CourseRepository> {
    @Autowired
    StudentRepository studentRepository;

    public void enrollStudentInCourse(StudentEntity student, CourseEntity course)
        {
            if (!student.getCourseEntityList().contains(course)) {
                student.getCourseEntityList().add(course);
                course.getStudentEntityList().add(student);
                repository.save(course);
                studentRepository.save(student);
            }
        }

        public void dropCourseFromStudent (StudentEntity student, CourseEntity course){
            if (student.getCourseEntityList().contains(course)) {
                student.getCourseEntityList().remove(course);
            }
            if (course.getStudentEntityList().contains(student)) {
                course.getStudentEntityList().remove(student);
            }

            repository.save(course);
            studentRepository.save(student);
        }

    @Override
    public CourseEntity insert(CourseEntity entity) {
        return super.insert(entity);
    }
}

