package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository ;
	
	public EmployeeServiceImpl( EmployeeRepository e) {
		employeeRepository=e;
	}
	@Override
	
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
	Optional<Employee>result = employeeRepository.findById(theId);
	Employee t=null;
	if(result.isPresent()) {
		t=result.get();
		
	}else {
//		we couldnt find an employee
		throw new RuntimeException("Did not find employee id - " +theId);
	}
	return t;
	}

	@Override
	
	public void save(Employee emp) {
		// TODO Auto-generated method stub

		employeeRepository.save(emp);
	}

	@Override
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
