package com.wellsfargo.fsd.coronakit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.fsd.coronakit.dao.CoronaKitDao;
import com.wellsfargo.fsd.coronakit.dao.DBConnectionDao;
import com.wellsfargo.fsd.coronakit.model.KitMaster;
import com.wellsfargo.fsd.coronakit.model.ProductMaster;

@WebServlet("/user")
public class UserController extends HttpServlet {
	KitMaster km =new KitMaster();
	private static final long serialVersionUID = 1L;
	HashMap<Integer, Integer> pcount = new HashMap<Integer, Integer>();
	ArrayList<ProductMaster> pms = new ArrayList<>();
	private String uname, email, phno;
	private static final String SELECT_USER_BY_ID = "select id,prodName,cost,prodDesc from product where id =?";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action" + action);

		String viewName = "";
		String action1 = "";
		int var;
		String vari = "";
		if (action.contains("?")) {
			var = action.indexOf("?");
			action1 = action.substring(0, var);
			vari = action.substring(var + 4, action.length());
			System.out.println("vari is" + vari);
		} else {
			action1 = action;
		}

		try {
			switch (action1) {
			case "newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "Add":
				viewName = addProductToCart(request, response, Integer.parseInt(vari));
				break;
			case "showproducts":
				viewName = showAllProducts(request, response);
				break;
			case "viewProduct":
				viewName = addNewItemToKit(request, response);
				break;
			case "deleteitem":
				viewName = deleteItemFromKit(request, response, Integer.parseInt(vari));
				break;
			case "showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "completeorder":
				viewName = completeOrder(request, response);
				break;
			case "ordersummary":
				viewName = showOrderSummary(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);

	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ProductMaster> pms = new ArrayList<>();
		int TotalQty = 0, TotalCost = 0;
		for (Integer key : pcount.keySet()) {
			try (Connection con = DBConnectionDao.getConnection();
					PreparedStatement pst = con.prepareStatement(SELECT_USER_BY_ID);) {
				pst.setInt(1, key);
				ResultSet rs = pst.executeQuery();
				ProductMaster pm = new ProductMaster();

				while (rs.next()) {

					pm = new ProductMaster();
					pm.setId(rs.getInt(1));
					pm.setProductName(rs.getString(2));
					pm.setCost(rs.getString(3));
					pm.setProductDescription(rs.getString(4));
					pm.setQty(pcount.get(key));
					int pCost = Integer.parseInt(rs.getString(3)) * pcount.get(key);
					pm.setPcost(pCost);
					TotalQty = TotalQty + pcount.get(key);
					TotalCost = TotalCost + pCost;
					pms.add(pm);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		request.getSession().setAttribute("prodList", pms);
		request.getSession().setAttribute("TotalQty", TotalQty);
		request.getSession().setAttribute("TotalCost", TotalCost);
		km.setAddress(request.getParameter("address"));
		km.setState(request.getParameter("state"));
		km.setZip(request.getParameter("zip"));
		request.getSession().setAttribute("username", km.getUname());
		request.getSession().setAttribute("phno", km.getPhno());
		request.getSession().setAttribute("email", km.getEmail());
		request.getSession().setAttribute("address", km.getAddress());
		request.getSession().setAttribute("state", km.getState());
		request.getSession().setAttribute("zip", km.getZip());
		return "ordersummary.jsp";
	}

	private String completeOrder(HttpServletRequest request, HttpServletResponse response) {
		
		return "Final.jsp";
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("username", km.getUname());
		request.getSession().setAttribute("phno", km.getPhno());
		request.getSession().setAttribute("email", km.getEmail());
		return "placeorder.jsp";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response, int id) {
		ArrayList<ProductMaster> pms = new ArrayList<>();
		int TotalQty = 0, TotalCost = 0;
		for (Integer key : pcount.keySet()) {
			if (id == key) {
				pcount.remove(key);
				break;
			}
		}
		for (Integer key : pcount.keySet()) {
			try (Connection con = DBConnectionDao.getConnection();
					PreparedStatement pst = con.prepareStatement(SELECT_USER_BY_ID);) {
				pst.setInt(1, key);
				ResultSet rs = pst.executeQuery();
				ProductMaster pm = new ProductMaster();

				while (rs.next()) {

					pm = new ProductMaster();
					pm.setId(rs.getInt(1));
					pm.setProductName(rs.getString(2));
					pm.setCost(rs.getString(3));
					pm.setProductDescription(rs.getString(4));
					pm.setQty(pcount.get(key));
					int pCost = Integer.parseInt(rs.getString(3)) * pcount.get(key);
					pm.setPcost(pCost);
					TotalQty = TotalQty + pcount.get(key);
					TotalCost = TotalCost + pCost;
					pms.add(pm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		request.getSession().setAttribute("prodList", pms);
		request.getSession().setAttribute("TotalQty", TotalQty);
		request.getSession().setAttribute("TotalCost", TotalCost);
		request.getSession().setAttribute("username", uname);

		return "showkit.jsp";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ArrayList<ProductMaster> pms = new ArrayList<>();
		int TotalQty = 0, TotalCost = 0;
		for (Integer key : pcount.keySet()) {
			try (Connection con = DBConnectionDao.getConnection();
					PreparedStatement pst = con.prepareStatement(SELECT_USER_BY_ID);) {
				pst.setInt(1, key);
				ResultSet rs = pst.executeQuery();
				ProductMaster pm = new ProductMaster();

				while (rs.next()) {

					pm = new ProductMaster();
					pm.setId(rs.getInt(1));
					pm.setProductName(rs.getString(2));
					pm.setCost(rs.getString(3));
					pm.setProductDescription(rs.getString(4));
					pm.setQty(pcount.get(key));
					int pCost = Integer.parseInt(rs.getString(3)) * pcount.get(key);
					pm.setPcost(pCost);
					TotalQty = TotalQty + pcount.get(key);
					TotalCost = TotalCost + pCost;
					pms.add(pm);
				}
			}

		}
		request.getSession().setAttribute("prodList", pms);
		request.getSession().setAttribute("TotalQty", TotalQty);
		request.getSession().setAttribute("TotalCost", TotalCost);
		request.getSession().setAttribute("username", uname);

		return "showkit.jsp";
	}

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		uname = request.getParameter("username");
		email = request.getParameter("emailaddress");
		phno = request.getParameter("contact");
		pms = CoronaKitDao.productList();
		km.setUname(uname);
		km.setEmail(email);
		km.setPhno(phno);
		request.getSession().setAttribute("username", uname);
		request.setAttribute("corona", pms);
		return "showproductstoadd.jsp";
	}

	private String addProductToCart(HttpServletRequest request, HttpServletResponse response, int id)
			throws SQLException {
		System.out.println("in addtion of cart");
		System.out.println("id value" + id);
		Integer count = pcount.get(id);
		if (count == null) {
			pcount.put(id, 1);
		} else {
			pcount.put(id, count + 1);
		}
		pms = CoronaKitDao.addToCart();
		request.setAttribute("message", "Added to Cart");
		request.setAttribute("corona", pms);
		return "showproductstoadd.jsp";

	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "newuser.jsp";
	}
}