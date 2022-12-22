package com.demo.controller;

import com.demo.model.Student;
import com.demo.service.IStudentService;
import com.demo.service.IStudentService;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
   private IStudentService iStudentService;
}
