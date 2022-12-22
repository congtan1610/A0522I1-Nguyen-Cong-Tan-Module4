package com.demo.repository;

import com.demo.model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> findAll();
}
