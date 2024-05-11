package com.insert.university.services;

import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.repositories.CourseRepository;
import com.insert.university.repositories.StudentRepository;
import com.insert.university.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService extends BaseService<CourseEntity, CourseRepository> {
   private final StudentRepository studentRepository;
   private final TeacherRepository teacherRepository;

    public void enrollStudentInCourse(StudentEntity student, CourseEntity course)
        {
            if (!student.getCourses().contains(course)) {
                student.getCourses().add(course);
                course.getStudents().add(student);
                repository.save(course);
                studentRepository.save(student);
            }
        }

        public void dropCourseFromStudent (StudentEntity student, CourseEntity course){
            if (student.getCourses().contains(course)) {
                student.getCourses().remove(course);
            }
            if (course.getStudents().contains(student)) {
                course.getStudents().remove(student);
            }

            repository.save(course);
            studentRepository.save(student);
        }

    @Override
    public CourseEntity insert(CourseEntity entity) {

        return super.insert(entity);
    }


}

