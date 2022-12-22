package com.demo.repository;

import com.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo{
    private static List<Student> list;
    static {
        list=new ArrayList<>();
        list.add(new Student("1","Tan"));
    }
    @Override
    public List<Student> findAll() {
        return list;
    }
}
