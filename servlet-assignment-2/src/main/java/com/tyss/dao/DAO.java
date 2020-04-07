package com.tyss.dao;

import java.util.List;

import com.tyss.beans.EmployeeDetails;
import com.tyss.beans.Login;

public interface DAO {
	
	void add(EmployeeDetails employeeDetails);
	
	List<EmployeeDetails> list();

	void delete(Integer id);

	void edit(EmployeeDetails employeeDetails);

	EmployeeDetails get(Integer id);
	
	Boolean validateLogin(Login user);
	
}
