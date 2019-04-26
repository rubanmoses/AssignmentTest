package com.rubanProject.AssignmentProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubanProject.AssignmentProject.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
