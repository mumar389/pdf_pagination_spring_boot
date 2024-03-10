package com.nri.trial.Oprations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nri.trial.Oprations.DAO.EmployeeRepo;
import com.nri.trial.Oprations.Entity.Student;

@Service
public class StudentService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Student> getAll(Integer pageNo, Integer pageSize) {
        // int pageSize = 5;
        // int pgNo = 1;

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Student> pageStud = employeeRepo.findAll(pageable);
        List<Student> allStudents = pageStud.getContent();
        return allStudents;
    }

    public Student saveToDb(Student stud) {
        return employeeRepo.save(stud);
    }

    public String saveList(List<Student> students){
        employeeRepo.saveAll(students);
        return "Saved";
    }
}
