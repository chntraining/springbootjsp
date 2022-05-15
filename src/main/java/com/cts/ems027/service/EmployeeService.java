package com.cts.ems027.service;

import java.util.List;

import com.cts.ems027.exception.EmployeeNotFoundException;
import com.cts.ems027.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	
	public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;
	public Employee  updateEmployee(Long employeeId, Employee employee);
	public void  updateEmp(Employee employee);
	
	public void deleteEmployee(Long employeeId);
	public Employee findEmployeeByEmail(String email);
	public List<Employee> findEmployeeByEmployeeName(String employeeName);
	public List<Employee> findByEmployeeNameOrderByEmployeeNameAsc(String employeeName);
}
