package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService t) {
		employeeService = t;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
//	add mapping for get/employee/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee e=employeeService.findById(employeeId);
		if(e==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		return e;
	}
//	add mapping for post /employees -add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee e) {
		e.setId(0);
		employeeService.save(e);
		return e;
	}
//	update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee e) {
		employeeService.save(e);
		return e;
	}
//	add a method for delete an employee /employees/{employeeId}
	@DeleteMapping("/employees/{e}")
	public String deleteEmployee(@PathVariable int e) {
		Employee f=employeeService.findById(e);
		if(f==null) {
			throw new RuntimeException("Employee id not found -"+e);
			}
		employeeService.deleteById(e);
		return "Deleted employee id -"+e;
	}

	
}










