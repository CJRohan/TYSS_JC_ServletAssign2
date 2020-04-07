package com.tyss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.beans.EmployeeDetails;
import com.tyss.beans.Login;
import com.tyss.factory.Factory;
import com.tyss.service.Service;


@SuppressWarnings("serial")
public class EmployeeController extends HttpServlet {

	private Service service;

	public EmployeeController() {
		service = Factory.getService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter writer = resp.getWriter();
		String action = req.getParameter("action");
		writer.print(action);
		RequestDispatcher dispatcher = null;
		
		if (action == null)
			action = "ENTRY";
		
		else if (!"LOGIN".equals(action) && !"loggedin".equals(session.getAttribute("admins"))) {
			action = "ENTRY";
			req.setAttribute("message", "Please Login First!!!");
		}
		
		switch (action) {
		case "ENTRY":
			dispatcher = req.getRequestDispatcher("");
			dispatcher.forward(req, resp);
			break;
		case "LOGIN":
			if (service.validate(new Login(req.getParameter("admin"),req.getParameter("pass")))) {
				session.setAttribute("admins", "loggedin");
				dispatcher = req.getRequestDispatcher("Views/welcome.jsp");
				dispatcher.forward(req, resp);
			} else {
				req.setAttribute("message", "Invalid Credentials.. Please try again!!!");
				dispatcher = req.getRequestDispatcher("Views/login.jsp");
				dispatcher.forward(req, resp);
			}
			break;
		case "WELCOME":
			dispatcher = req.getRequestDispatcher("Views/welcome.jsp");
			dispatcher.forward(req, resp);
			break;
		case "LIST":
			writer.print("LISTING");
			req.setAttribute("employees", service.list());
			dispatcher = req.getRequestDispatcher("Views/list.jsp");
			dispatcher.forward(req, resp);
			break;
		case "GET":
			writer.print("GET");
			EmployeeDetails employeeDetails1 = null;
			try {
				employeeDetails1 = service.get(Integer.parseInt(req.getParameter("id")));
			} catch(Exception e) {
				req.setAttribute("message", "Enter a number please");
				dispatcher = req.getRequestDispatcher("Views/welcome.jsp");
				dispatcher.forward(req, resp);
				break;
			}
			if ( employeeDetails1  == null) {
				req.setAttribute("message", "ID does not exist");
				dispatcher = req.getRequestDispatcher("Views/welcome.jsp");
				dispatcher.forward(req, resp);
				break;
			}
			List<EmployeeDetails> e = new ArrayList<EmployeeDetails>();
			e.add(employeeDetails1);
			req.setAttribute("employees", e);
			dispatcher = req.getRequestDispatcher("Views/list.jsp");
			dispatcher.forward(req, resp);
			break;		
		case "ADD":
			writer.print(action);
			dispatcher = req.getRequestDispatcher("Views/add.jsp");
			dispatcher.forward(req, resp);
			break;
		case "ADDEmployee":
			writer.print(action);
			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setName(req.getParameter("name"));
			employeeDetails.setMailid(req.getParameter("mail"));
			employeeDetails.setDob(LocalDate.parse(req.getParameter("dob")));
			employeeDetails.setJoined(LocalDate.parse(req.getParameter("joined")));
			employeeDetails.setManagerid(req.getParameter("managerid"));
			employeeDetails.setDeptid(req.getParameter("deptid"));
			employeeDetails.setDesignation(req.getParameter("designation"));
			employeeDetails.setMobile(req.getParameter("mobile"));
			employeeDetails.setSalary(req.getParameter("salary"));
			employeeDetails.setPassword(req.getParameter("password"));
			if (req.getParameter("id") == "") {
				service.add(employeeDetails);
				req.setAttribute("message", "Employee Added succesfully!!!");
			} else {
				employeeDetails.setEmpid(Integer.parseInt(req.getParameter("id")));
				service.edit(employeeDetails);
				req.setAttribute("message", "Employee Updated succesfully!!!");
			}
			dispatcher = req.getRequestDispatcher("Views/add.jsp");
			dispatcher.forward(req, resp);
			break;
		case "EDIT":
			writer.print(action);
			req.setAttribute("id", req.getParameter("id"));
			req.setAttribute("password", req.getParameter("password"));
			req.setAttribute("name", req.getParameter("name"));
			req.setAttribute("mail", req.getParameter("mail"));
			req.setAttribute("dob", req.getParameter("dob"));
			req.setAttribute("joined", req.getParameter("joined"));
			req.setAttribute("deptid", req.getParameter("deptid"));
			req.setAttribute("managerid", req.getParameter("managerid"));
			req.setAttribute("designation", req.getParameter("designation"));
			req.setAttribute("salary", req.getParameter("salary"));
			req.setAttribute("mobile", req.getParameter("mobile"));
			dispatcher = req.getRequestDispatcher("Views/add.jsp");
			dispatcher.forward(req, resp);
			break;
		case "DELETE":
			writer.print(action);
			service.delete(Integer.parseInt(req.getParameter("id")));
			System.out.println(req.getParameter("id"));
			req.setAttribute("employees", service.list());
			req.setAttribute("message", "Record Deleted Successfully!!!");
			dispatcher = req.getRequestDispatcher("Views/list.jsp");
			dispatcher.forward(req, resp);
			break;
		case "LOGOUT":
			req.setAttribute("message", "You have sucessfully logged out!!!");
			session.setAttribute("admins", "");
			dispatcher = req.getRequestDispatcher("Views/login.jsp");
			dispatcher.forward(req, resp);
		default:
			writer.print("UnderATTACK");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
