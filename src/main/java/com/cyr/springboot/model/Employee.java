package com.cyr.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TABLE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Employee_id;
	private String Employee_name;
    
	private String Employee_designation;
	private String Employee_departement;

	public String getEmployee_departement() {
		return Employee_departement;
	}

	public void setEmployee_departement(String employee_departement) {
		Employee_departement = employee_departement;
	}

	public int getEmployee_id() {
		return Employee_id;
	}

	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}

	public String getEmployee_name() {
		return Employee_name;
	}

	public void setEmployee_name(String employee_name) {
		Employee_name = employee_name;
	}

	public String getEmployee_designation() {
		return Employee_designation;
	}

	public void setEmployee_designation(String employee_designation) {
		Employee_designation = employee_designation;
	}

	@Override
	public String toString() {
		return "Employee [Employee_id=" + Employee_id + ", Employee_name=" + Employee_name + ", Employee_designation="
				+ Employee_designation + ", Employee_departement=" + Employee_departement
				+ ", getEmployee_departement()=" + getEmployee_departement() + ", getEmployee_id()=" + getEmployee_id()
				+ ", getEmployee_name()=" + getEmployee_name() + ", getEmployee_designation()="
				+ getEmployee_designation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
