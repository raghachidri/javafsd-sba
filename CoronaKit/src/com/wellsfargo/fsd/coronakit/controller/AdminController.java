package com.wellsfargo.fsd.coronakit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.coronakit.dao.CoronaKitDao;
import com.wellsfargo.fsd.coronakit.model.ProductMaster;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	ArrayList<ProductMaster> pms = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String viewName = "";
		String action1 = "";
		int var;
		String vari = "";
		if (action.contains("?")) {
			var = action.indexOf("?");
			action1 = action.substring(0, var);
			vari = action.substring(var + 4, action.length());
		} else {
			action1 = action;
		}
		try

		{
			switch (action1) {
			case "login":
				if (request.getParameter("loginid").contentEquals("admin")
						&& request.getParameter("password").contentEquals("admin")) {
					viewName = adminLogin(request, response);
				}
				else {
					viewName="error.jsp";
				}
				break;
			case "newproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response, Integer.parseInt(vari));
				break;
			case "editproduct":
				viewName = showEditProductForm(request, response, Integer.parseInt(vari));
				break;
			case "updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;
			 default : viewName = "notfound.jsp"; break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);

	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	public String updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String cost = request.getParameter("cost");
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		CoronaKitDao.updateProduct(productName, cost, productDescription, id);
		pms = CoronaKitDao.productList();
		request.setAttribute("corona", pms);
		request.setAttribute("msg", productName + " is Updated in Corona Kit");
		return "listproducts.jsp";
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response, int id)
			throws SQLException {

		ProductMaster pm = CoronaKitDao.editProduct(id);
		request.setAttribute("prodList", pm);
		return "editproduct.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response, int id) throws SQLException {

		CoronaKitDao.deleteProduct(id);
		pms = CoronaKitDao.productList();
		request.setAttribute("corona", pms);
		request.setAttribute("msg", id + " is deleted from Corona Kit");
		return "listproducts.jsp";
	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		String productName = request.getParameter("productName");
		String cost = request.getParameter("cost");
		String productDescription = request.getParameter("productDescription");
		CoronaKitDao.insertNewProduct(productName, cost, productDescription);

		pms = CoronaKitDao.productList();
		request.setAttribute("corona", pms);
		request.setAttribute("msg", productName + " is added into Corona Kit");

		return "listproducts.jsp";
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		return "newproduct.jsp";
	}
	private String adminLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		pms = CoronaKitDao.productList();
		request.setAttribute("corona", pms);
		return "listproducts.jsp";
	}

}