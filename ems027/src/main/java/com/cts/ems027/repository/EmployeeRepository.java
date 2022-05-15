package com.cts.ems027.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ems027.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public List<Employee> findEmployeeByEmployeeName(String employeeName);
	public Employee findEmployeeByEmail(String email);
	
	public List<Employee> findByEmployeeNameOrderByEmployeeNameAsc(String employeeName);
	
}
