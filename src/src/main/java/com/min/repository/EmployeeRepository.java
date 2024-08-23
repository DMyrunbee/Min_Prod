package com.min.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.min.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    //public Optional<Employee> deleteById(Integer id);
}
