package com.insert.university.services;

import com.insert.university.model.entities.StudentEntity;
import com.insert.university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService<StudentEntity,StudentRepository> {

private  StudentEntity studentEntity;

    public StudentEntity createAccount(String studentName, String studentFamily,String studentNationalCode ) {
        if (studentName == null || studentFamily == null|| studentNationalCode==null) {
            throw new IllegalArgumentException("نام دانشجو و ایمیل نمی‌تواند خالی باشد");
        }

        studentEntity.setName(studentName);
        studentEntity.setFamily(studentFamily);
        studentEntity.setNationalCode(studentNationalCode);


        repository.save(studentEntity);

        return studentEntity;
    }
}
