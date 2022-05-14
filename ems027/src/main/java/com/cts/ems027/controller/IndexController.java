package com.cts.ems027.controller;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ems027.exception.EmployeeNotFoundException;
import com.cts.ems027.model.Employee;
import com.cts.ems027.service.EmployeeService;

@Controller
public class IndexController {
	@Autowired
	public EmployeeService employeeService;
	Employee employee;

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Index page invoked :) !!");
		return "index";
	}

	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("mess", "You are in next page CDBDX027 !!");
		return "next";
	}

	@RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");

	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView signin() {
		return new ModelAndView("login");

	}

	@RequestMapping(value = "/addemp", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtename") String ename, @RequestParam("txtemail") String email,
			@RequestParam("txtpass") String password, @RequestParam("txtgender") String gender,
			@RequestParam("dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob) {

		System.out.println(ename + "  " + email + "  " + password + "  " + gender + "  " + dob);
		employee = new Employee();
		employee.setEmployeeName(ename);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setGender(gender);
		employee.setDob(dob);
		employeeService.saveEmployee(employee);
		return new ModelAndView("login");

	}

	public ModelAndView allEmplloyees() {
		List<Employee> li = employeeService.getAllEmployees();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", li);
		return mv;

	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("txtemail") String email, @RequestParam("txtpass") String password)
			throws EmployeeNotFoundException {

		employee = new Employee();
		employee.setEmail(email);

		Employee empl = employeeService.findEmployeeByEmail(email);

		if (empl == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("NOTIFICATION", "Employee Doesn't exist...");
			return mv;

		} else {

			return allEmplloyees();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Employee empl) {
		employeeService.deleteEmployee(empl.getEmployeeId());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", employeeService.getAllEmployees());
		return mv;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView mv = new ModelAndView("edit");
		return mv;

	}

	@RequestMapping(value = "/updateEmpl", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute("employee") Employee empl) {
		System.out.println("uuuuuuuuuuuuuuuuuuuuuu" + empl);
		employeeService.updateEmp(empl);

		return allEmplloyees();
	}

}
