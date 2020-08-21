package com.wellsfargo.fsd.cpk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.cpk.entity.Item;
import com.wellsfargo.fsd.cpk.entity.OrderItem;
import com.wellsfargo.fsd.cpk.exception.ImsException;
import com.wellsfargo.fsd.cpk.service.ItemService;
import com.wellsfargo.fsd.cpk.service.ItemServiceImpl;

/**
 * Servlet implementation class UserCheckOutController
 */
@WebServlet("/Checkout")
public class UserCheckOutController extends HttpServlet {
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
		case "/Checkout": viewName=doCheckout(request, response); break;
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
 
	
	protected String doCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> items;
		List<OrderItem> orderItems = new ArrayList();
		String view="";
		try {
			items = itemService.getAllItems();
			  System.out.println(request);
			  double total = 0;
			  for (Item item: items) {				
			  if ("ON".equalsIgnoreCase(request.getParameter(String.valueOf(item.getIcode())))) {
				  System.out.println(request.getParameter(item.getIcode()+"_quantity"));
				  int quantity = Integer.parseInt(request.getParameter(item.getIcode()+"_quantity"));
				  double subTotal = quantity * item.getPrice();
				  System.out.println("subTotal="+subTotal);
				  total += subTotal;
				  OrderItem orderItem = new OrderItem();
				  orderItem.setItem(item);
				  orderItem.setQuantity(quantity);
				  orderItems.add(orderItem);
			  	}
			  }
			  System.out.println("total="+total);
			  request.setAttribute("total", total);
			  request.setAttribute("orderedItems", orderItems);
			  view="orderSummary.jsp";
			  
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}
	

}
