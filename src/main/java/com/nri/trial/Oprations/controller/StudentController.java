package com.nri.trial.Oprations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nri.trial.Oprations.Entity.Student;
import com.nri.trial.Oprations.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add-all")
    public String saveList(@RequestBody List<Student> studentList) {
        // System.out.println(studentList);
      studentService.saveList(studentList);
        return "Saved";
    }

    @GetMapping("/get")
    public List<Student> getByPageNumber(@RequestParam(defaultValue = "0") Integer pageNumber,@RequestParam(defaultValue = "5") Integer pageSize){
        return studentService.getAll(pageNumber, pageSize);
    }

}
