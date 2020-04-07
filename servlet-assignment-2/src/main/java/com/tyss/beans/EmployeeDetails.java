package com.tyss.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
public class EmployeeDetails implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empid;
	@Column
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(unique = true)
	private String mailid;
	@Column
	private LocalDate dob;
	@Column
	private LocalDate joined;
	@Column
	private String deptid;
	@Column
	private String managerid;
	@Column
	private String designation;
	@Column
	private String salary;
	@Column(unique = true)
	private String mobile;
	

	public EmployeeDetails() {

	}


	public Integer getEmpid() {
		return empid;
	}


	public void setEmpid(Integer empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public LocalDate getJoined() {
		return joined;
	}


	public void setJoined(LocalDate joined) {
		this.joined = joined;
	}

	public String getDeptid() {
		return deptid;
	}


	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}


	public String getManagerid() {
		return managerid;
	}


	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	
	

}
