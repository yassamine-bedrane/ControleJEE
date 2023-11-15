package com.controle.bedrane.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.bedrane.entities.Employee;
import com.controle.bedrane.services.EmployeeService;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> findAllEmployees(){
		return employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findEmployeeById(@PathVariable Long id){
		Employee employee = employeeService.findById(id);
		if(employee==null) {
			return new ResponseEntity<Object>("Employee with id "+id+" not found",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(employee);
		
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		employee.setId(0L);
		return employeeService.create(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		Employee employee2 = employeeService.findById(id);
		if(employee2==null) {
			return new ResponseEntity<Object>("Employee with id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		else {
			employee.setId(id);
			return ResponseEntity.ok(employeeService.update(employee));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeService.findById(id);
		if(employee==null) {
			return new ResponseEntity<Object>("Employee with id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(employeeService.delete(employee));
	}
}
