package com.cts.ems027.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.ems027.exception.EmployeeNotFoundException;
import com.cts.ems027.model.Employee;
import com.cts.ems027.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
		
	@Override
	public Employee saveEmployee(Employee employee) {
		System.out.println("To Save : " + employee);
		return employeeRepository.save(employee) ;
	}

	@Override
	public List<Employee> getAllEmployees() {		
		return employeeRepository.findAll();
	}

	@Override	
	public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException  {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee NOT FOUND :(");
		}
		return employee.get();
	}
 	
	@Override	
	public Employee updateEmployee(Long employeeId, Employee employee) {
		System.out.println("ddddddddddddddddddddddddddddddddddddddddddd"+employee);
		Employee emp= employeeRepository.findById(employeeId).get();
		
		if(Objects.nonNull(emp.getEmployeeName())) {
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setDob(employee.getDob());
		}		
		return employeeRepository.save(emp);
	}

	@Override
	public void updateEmp(Employee employee) {
		
		Employee emp= employeeRepository.findById(employee.getEmployeeId()).get();
	
		if(Objects.nonNull(emp.getEmployeeName())) {
			emp.setEmployeeName(employee.getEmployeeName());
		}		
		employeeRepository.save(emp);
	}
	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		System.out.println("Deleted " + employeeId + " successfully !!!");		
	}

	@Override
	public List<Employee> findEmployeeByEmployeeName(String employeeName){	
		return employeeRepository.findEmployeeByEmployeeName(employeeName);
	}

	
	@Override
	public List<Employee> findByEmployeeNameOrderByEmployeeNameAsc(String employeeName) {	
		return employeeRepository.findByEmployeeNameOrderByEmployeeNameAsc(employeeName);
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		
		return employeeRepository.findEmployeeByEmail(email);
	}

	

}
