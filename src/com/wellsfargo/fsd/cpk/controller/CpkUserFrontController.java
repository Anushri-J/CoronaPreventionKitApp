package com.wellsfargo.fsd.cpk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.cpk.entity.Item;
import com.wellsfargo.fsd.cpk.exception.ImsException;
import com.wellsfargo.fsd.cpk.service.ItemService;
import com.wellsfargo.fsd.cpk.service.ItemServiceImpl;

/**
 * Servlet implementation class CpkUserFrontController
 */
@WebServlet("/listAllProducts")
public class CpkUserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ItemService itemService;
	
	@Override
	public void init() throws ServletException {
		itemService = new ItemServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		String viewName="";
		
		switch(url) {
		case "/listAllProducts": viewName=doList(request, response); break;
		}
		request.getRequestDispatcher(viewName).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view="";
		try {
			List<Item>item = itemService.getAllItems();
			request.setAttribute("items", item);
			view="showProductsToAdd.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}		
		return view;		
	}

}
