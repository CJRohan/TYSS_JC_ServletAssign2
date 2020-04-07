package com.tyss.service;

import java.util.List;

import com.tyss.beans.EmployeeDetails;
import com.tyss.beans.Login;

public interface Service {

	void add(EmployeeDetails employeeDetails);

	List<EmployeeDetails> list();

	void delete(Integer id);

	void edit(EmployeeDetails employeeDetails);
	
	EmployeeDetails get(Integer id);

	Boolean validate(Login login);
}
