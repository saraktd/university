package com.insert.university.services;

import com.insert.university.model.entities.CourseEntity;
import com.insert.university.model.entities.StudentEntity;
import com.insert.university.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends BaseService<StudentEntity,StudentRepository> {
StudentEntity studentEntity;

    public List<StudentEntity> createAccount(String studentName, String studentFamily, String studentNationalCode ) {
        if (studentName == null || studentFamily == null|| studentNationalCode==null) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }

        studentEntity.setName(studentName);
        studentEntity.setFamily(studentFamily);
        studentEntity.setNationalCode(studentNationalCode);


         repository.save(studentEntity);

        return (List<StudentEntity>) studentEntity;
    }
    public void deleteAccount(Long id) {
        if (id == null ) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }

        repository.findById(id);
        repository.deleteById(id);

    }

    public Long calculateTotalUnits(Long studentId) {
        StudentEntity student = repository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return student.getCourseEntityList().stream()
                .mapToLong(CourseEntity::getUnit)
                .sum();

    }
}
