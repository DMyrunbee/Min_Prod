package com.min.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.domain.Employee;
import com.min.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

@Autowired
private EmployeeRepository employeeRepository;

	
	public Employee saveEmployee(Employee employee) {
        System.out.println("Employee's created successfully");
        return employeeRepository.save(employee);
	}

  /*public List<Employee> createEmployee(Employee employee) {
        System.out.println("Employee created successfully...");
        return employeeRepository.save(employee);
    }
*/
    public Employee updateEmployee(Integer id, Employee employeeFirstName) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setEmployeeFirstName(employeeFirstName.getEmployeeFirstName());
       // employee.setEmployeeLastName(employeeLastName.getEmployeeLastName());
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployeeById(){
        Integer id=null;
        return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found" )));
    }
    public Employee deleteEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }



   /* public void deleteEmployee(Integer id) {

        employeeRepository.deleteById(id);
    }*/


    /*public Optional<Object> getEmployeeById(Integer id) {

        return null;
    }
*/

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
