package com.cyr.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyr.springboot.dao.EmployeeDao;
import com.cyr.springboot.model.Employee;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{
	
	
	@Autowired
	private EmployeeDao employeedao;
	

	public EmployeeDao getEmployeedao() {
		return employeedao;
	}

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeedao.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeedao.findAll();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeedao.deleteById(employeeId);
		
	}

	@Override
	public Employee getEmployee(int employeeid) {
		return employeedao.getById(employeeid);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeedao.save(employee);
	}

	
}
