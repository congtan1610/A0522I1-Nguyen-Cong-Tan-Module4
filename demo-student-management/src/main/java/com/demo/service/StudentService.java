package com.demo.service;

import com.demo.model.Student;
import com.demo.repository.IStudentRepo;
import com.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService implements IStudentService{
@Autowired
    private IStudentRepo iStudentRepo;
    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }
}
