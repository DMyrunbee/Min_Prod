package com.min.controller;

//import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.min.domain.Employee;
import com.min.service.EmployeeService;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	/*@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
	Employee employee2 =	employeeService.saveEmployee(employee);
		return employee2 ;
		}*/


	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	}



/*@PutMapping("/Edit")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
	//Employee employeeFirstName = null;
	Object id=null;
	employeeService.updateEmployee(Integer, id);
		return  ResponseEntity.noContent().build();
		//System.out.println("Employee details updated");
	}*/
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable Integer id,
			@RequestBody Employee employee) {
		Optional<Employee> updateEmployee = Optional.ofNullable(employeeService.updateEmployee(id, employee));
		if (updateEmployee.isPresent()) {
			return ResponseEntity.ok(updateEmployee.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}


	/*@GetMapping("/emp/create")
	public List<Employee> createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee)
				;}*/

				 @GetMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeByName(@PathVariable Integer id) {
    	employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
    }

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable Integer id,@RequestBody Employee employee) {
		Object object = employeeService.getEmployeeById()

				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
return ResponseEntity.noContent().build();
	}
    /* public */
	@DeleteMapping("/emp/{id}" )
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer id) {
		boolean isDeleted = employeeService.deleteEmployeeById(id).getArchive();
		if (isDeleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}



}


























