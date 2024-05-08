package com.insert.university.services;

import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.model.entities.TeacherEntity;
import com.insert.university.repositories.CourseRepository;
import com.insert.university.repositories.StudentRepository;
import com.insert.university.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService extends BaseService<StudentEntity, StudentRepository> {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public StudentEntity createAccount(String studentName, String studentFamily, String studentNationalCode) {
        if (studentName == null || studentFamily == null || studentNationalCode == null) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentName);
        studentEntity.setFamily(studentFamily);
        studentEntity.setNationalCode(studentNationalCode);

        studentRepository.save(studentEntity);

        return studentEntity;
    }

    public void deleteAccount(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("Account with ID: " + id + " does not exist");
        }
        try {
            studentRepository.deleteById(id);
            System.out.println("The desired user has been successfully deleted");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void removeCourseFromStudent(Long studentID, Long courseId) {
        StudentEntity testudent = studentRepository.findById(studentID).orElseThrow(() -> new RuntimeException("Teacher not found"));
        CourseEntity course = testudent.getCourseEntityList().stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The course was not found in the teacher's list"));
        testudent.getCourseEntityList().remove(course);
        studentRepository.save(testudent);
    }
    @Transactional
    public void addCourseToStudent(Long studentId, Long courseId,Long tescherId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        TeacherEntity teacherEntity = teacherRepository.findById(tescherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));


        student.getCourseEntityList().add(course);
        course.getStudentEntityList().add(student);
        course.getTeacherEntityList().add(teacherEntity);
        teacherEntity.getCourseEntityList().add(course);
        student.getTeacherEntityList().add(teacherEntity);
        teacherEntity.getStudentEntityList().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
        teacherRepository.save(teacherEntity);




    }
}
