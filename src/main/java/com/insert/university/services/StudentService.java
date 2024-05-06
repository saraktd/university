package com.insert.university.services;

import com.insert.university.model.entities.StudentEntity;
import com.insert.university.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService<StudentEntity,StudentRepository> {
}
