package com.wellsfargo.fsd.cpk.controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class cpkFrontController
 */
@WebServlet({"/listProducts","/addProduct","/newProduct","/deleteProduct","/editProduct","/saveProduct"})
public class cpkFrontController extends HttpServlet {
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
		case "/listProducts": viewName=doList(request, response); break;
		case "/addProduct": viewName=doAddProduct(request, response); break;
		case "/newProduct": viewName=doNewProduct(request, response); break;
		case "/deleteProduct": viewName=doDeleteProduct(request, response); break;
		case "/editProduct": viewName=doEditProduct(request, response); break;
		case "/saveProduct": viewName=doSaveProduct(request, response); break;
		}
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	public String doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view="";
		try {
			List<Item>item = itemService.getAllItems();
			request.setAttribute("items", item);
			view="listProducts.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		
		
		return view;		
	}
	public String doNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Item item = new Item();
		request.setAttribute("item", item);
		
		return "itemFormPage.jsp";
				
	}
	public String doAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Item item = new Item();
		
		item.setIcode(Integer.parseInt(request.getParameter("icode")));
		item.setTitle(request.getParameter("title"));
		item.setUnit(request.getParameter("unit"));
		item.setPrice(Double.parseDouble(request.getParameter("price")));
		
		String view="";
		
		try {
			itemService.validateAndAdd(item);
			request.setAttribute("msg", "Product Got Added!");
			view="adminPage.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}
	public String doDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int icode = Integer.parseInt(request.getParameter("icode"));
		String view="";
		
		try {
			itemService.deleteItem(icode);
			request.setAttribute("msg", "Product got Deleted!");
			view="adminPage.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}
	public String doEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int icode = Integer.parseInt(request.getParameter("icode"));
		String view="";
						
		try {
			Item item = itemService.getItemById(icode);
			request.setAttribute("item", item);
			view="itemFormPage.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}
	public String doSaveProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Item item = new Item();
		
		item.setIcode(Integer.parseInt(request.getParameter("icode")));
		item.setTitle(request.getParameter("title"));
		item.setUnit(request.getParameter("unit"));
		item.setPrice(Double.parseDouble(request.getParameter("price")));
		
		
		String view="";
		
		try {
			itemService.validateAndSave(item);
			request.setAttribute("msg", "Product Got Saved!");
			view="adminPage.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}
}
