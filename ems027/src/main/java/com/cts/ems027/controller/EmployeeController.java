package com.cts.ems027.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ems027.exception.EmployeeNotFoundException;
import com.cts.ems027.model.Employee;
import com.cts.ems027.service.EmployeeService;

@RestController
@RequestMapping("/ctsemployee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String helloApp() {
		return "Hi DX22027 -- Welcome to Spring Boot Application :)";
	}

	@PostMapping("/addemployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/allemployees")
	public List<Employee> fethAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/empById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long empId) throws EmployeeNotFoundException {
			return new ResponseEntity<Employee>(employeeService.fetchEmployeeById(empId), HttpStatus.OK);

	}

	/*@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeNotFoundException> handleEmployeeNotFoundException(
			EmployeeNotFoundException employeeNotFoundException) {
		EmployeeNotFoundException exception = new EmployeeNotFoundException("Emp NOT FouND :( :( :(");

		return new ResponseEntity(exception, HttpStatus.NOT_FOUND);
	}*/

	@DeleteMapping("/delemp/{id}")
	public String deleteEmployee(@PathVariable("id") Long empId) {
		employeeService.deleteEmployee(empId);
		return "Employee " + empId + " deleted Successfully !!!";
	}

	@PutMapping("/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee.getEmployeeId(), employee);
	}

	@GetMapping("/empByName/{ename}")
	public List<Employee> fetchByEname(@PathVariable("ename") String empname) {
		return employeeService.findEmployeeByEmployeeName(empname);
	}

	@GetMapping("/empByNameAsc/{ename}")
	public List<Employee> fetchByEnameAsc(@PathVariable("ename") String empname) {
		return employeeService.findByEmployeeNameOrderByEmployeeNameAsc(empname);
	}

}
