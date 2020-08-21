package com.wellsfargo.fsd.cpk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewUserController
 */
@WebServlet("/NewUserController")
public class NewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String Email_id = request.getParameter("Email_id");
		String address = request.getParameter("address");
		String Contact_no = request.getParameter("Contact_no");
		
		RequestDispatcher rd = request.getRequestDispatcher("newUserPage.jsp");		
		rd.forward(request, response);
	}

}
