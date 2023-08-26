package com.cyr.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyr.springboot.dao.EmployeeDao;
import com.cyr.springboot.model.Employee;
import com.cyr.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeConroller {

	@Autowired
	private EmployeeDao repo;
	@Autowired
	private EmployeeService employeeservice;

	public EmployeeDao getRepo() {
		return repo;
	}

	public void setRepo(EmployeeDao repo) {
		this.repo = repo;
	}

	public EmployeeService getEmployeeservice() {
		return employeeservice;
	}

	public void setEmployeeservice(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee employee) {
		if (employee.getEmployee_id() == 0) {
			employeeservice.saveEmployee(employee);
		}
		return "Saved Successfully";
	}
@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		employee.setEmployee_id(id);
		Employee updateEmployees = repo.save(employee);
		return new ResponseEntity<>(updateEmployees, HttpStatus.OK);
	}

	/*
	 * @PutMapping("/editEmployee/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
	 * Optional<Employee> employeeData = repo.findById(id); if
	 * (employeeData.isPresent()) { Employee _data = employeeData.get();
	 * _data.setEmployee_name(employee.getEmployee_name());
	 * _data.setEmployee_designation(employee.getEmployee_designation());
	 * _data.setEmployee_departement(employee.getEmployee_departement()); return new
	 * ResponseEntity<>(repo.save(_data), HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listEmployee() {
		return new ResponseEntity<List<Employee>>(employeeservice.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/employeeById/{id}")
	public ResponseEntity<Employee> getcById(@PathVariable int id) {
		if (repo.findById(id).isPresent()) {
			return new ResponseEntity<Employee>(employeeservice.getEmployee(id), HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

}
