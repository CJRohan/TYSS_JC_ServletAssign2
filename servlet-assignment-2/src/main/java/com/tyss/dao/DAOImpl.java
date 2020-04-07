package com.tyss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tyss.beans.EmployeeDetails;
import com.tyss.beans.Login;

public class DAOImpl implements DAO {

	@Override
	public void add(EmployeeDetails employeeDetails) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(employeeDetails);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public List<EmployeeDetails> list() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<EmployeeDetails> query = entityManager.createQuery("from EmployeeDetails", EmployeeDetails.class);
		List<EmployeeDetails> employeeDetails = query.getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return employeeDetails;
	}
	
	@Override
	public EmployeeDetails get(Integer id) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<EmployeeDetails> query = entityManager.createQuery("from EmployeeDetails where empid = "
				 + id, EmployeeDetails.class);
		List<EmployeeDetails> employeeDetails = query.getResultList();

		entityManager.close();
		entityManagerFactory.close();

		if (employeeDetails.isEmpty())
			return null;
		return employeeDetails.get(0);
	}

	@Override
	public void delete(Integer id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("delete from EmployeeDetails where empid = " + id);
		query.executeUpdate();

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}

	@Override
	public void edit(EmployeeDetails employeeDetails) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Query query = entityManager.createQuery("update EmployeeDetails set name = '" + employeeDetails.getName()
				+ "', mailid = '" + employeeDetails.getMailid() + "', password = '" + employeeDetails.getPassword()
				+ "', dob = '" + employeeDetails.getDob() + "', joined = '" + employeeDetails.getJoined()
				+ "', deptid = '" + employeeDetails.getDeptid() + "', managerid = '" + employeeDetails.getManagerid()
				+ "', designation = '" + employeeDetails.getDesignation() + "', salary = '" + employeeDetails.getSalary()
				+ "', mobile = '" + employeeDetails.getMobile() +"' where empid = '" + employeeDetails.getEmpid() + "'");
		query.executeUpdate();

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public Boolean validateLogin(Login user) {
		return user.getAdmin().equalsIgnoreCase("chandan") && user.getPassword().equalsIgnoreCase("thankyou");
	}

}
