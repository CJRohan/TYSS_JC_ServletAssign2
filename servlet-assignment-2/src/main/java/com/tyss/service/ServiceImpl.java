package com.tyss.service;

import java.util.List;

import com.tyss.beans.EmployeeDetails;
import com.tyss.beans.Login;
import com.tyss.dao.DAO;
import com.tyss.factory.Factory;

public class ServiceImpl implements Service {
	
	DAO dao;
	
	public ServiceImpl() {
		dao = Factory.getDAO();
	}

	@Override
	public void add(EmployeeDetails employeeDetails) {
		dao.add(employeeDetails);
	}

	@Override
	public List<EmployeeDetails> list() {
		return dao.list();
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void edit(EmployeeDetails employeeDetails) {
		dao.edit(employeeDetails);
	}

	@Override
	public EmployeeDetails get(Integer id) {
		return dao.get(id);
	}

	@Override
	public Boolean validate(Login user) {
		return dao.validateLogin(user);
	}
	
	

}
