package com.insert.university.services;

import com.insert.university.common.CourseDto;
import com.insert.university.common.StudentDto;
import com.insert.university.converter.StudentConverter;
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
    private final StudentConverter studentConverter;

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
        CourseEntity course = testudent.getCourses().stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The course was not found in the teacher's list"));
        testudent.getCourses().remove(course);
        studentRepository.save(testudent);
    }

    @Transactional
    public void addCourseToStudent(Long studentId, Long courseId, Long teشcherId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        TeacherEntity teacher = teacherRepository.findById(teشcherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));


        student.getCourses().add(course);
        course.getStudents().add(student);
        course.setTeacher(teacher);
        teacher.getCourses().add(course);
        teacher.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
        teacherRepository.save(teacher);

    }
    public StudentDto getStudentById(Long id) throws Exception {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));
        StudentDto studentDto=new StudentDto();
        studentDto=studentConverter.convertEtoD(student);
        return studentDto ;
    }

}
