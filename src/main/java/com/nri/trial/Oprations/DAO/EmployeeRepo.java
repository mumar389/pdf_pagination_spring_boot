package com.nri.trial.Oprations.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nri.trial.Oprations.Entity.Student;

@Repository
public interface EmployeeRepo extends JpaRepository<Student,Long> {
    
}
