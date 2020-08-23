package com.wellsfargo.fsd.coronakit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wellsfargo.fsd.coronakit.model.ProductMaster;

public class CoronaKitDao {

	public static final String GET_BY_ID_LN_QRY = "SELECT * FROM Product";
	public static final String INSER_DATA_QRY = "INSERT INTO Product (prodName,cost,prodDesc)  values(?,?,?)";

	private static final String DELETE_USERS_SQL = "delete from product where id = ?;";
	private static final String SELECT_USER_BY_ID = "select id,prodName,cost,prodDesc from product where id =?";
	private static final String UPDATE_USERS_SQL = "update product set prodName = ?,cost= ?, prodDesc =? where id = ?;";
	static ProductMaster pm = null;

	public static ArrayList<ProductMaster> productList() {
		ArrayList<ProductMaster> pms = new ArrayList<>();
		try (Connection con = DBConnectionDao.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_LN_QRY);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				pm = new ProductMaster();
				pm.setId(rs.getInt(1));
				pm.setProductName(rs.getString(2));
				pm.setCost(rs.getString(3));
				pm.setProductDescription(rs.getString(4));
				pms.add(pm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pms;
	}

	public static void insertNewProduct(String productName, String cost, String productDescription) {
		try (Connection con = DBConnectionDao.getConnection();
				PreparedStatement pst = con.prepareStatement(INSER_DATA_QRY);) {
			pst.setString(1, productName);
			pst.setString(2, cost);
			pst.setString(3, productDescription);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ProductMaster editProduct(int id) {
		try (Connection con = DBConnectionDao.getConnection();
				PreparedStatement statement = con.prepareStatement(SELECT_USER_BY_ID);) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String cost = rs.getString("cost");
				String productName = rs.getString("prodName");
				String productDescription = rs.getString("prodDesc");
				pm = new ProductMaster(id, productName, cost, productDescription);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pm;
	}

	public static void updateProduct(String productName, String cost, String pdesc, int id) {
		try (Connection con = DBConnectionDao.getConnection();
				PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, productName);
			statement.setString(2, cost);
			statement.setString(3, pdesc);
			statement.setInt(4, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteProduct(int id) {
		try (Connection con = DBConnectionDao.getConnection();
				PreparedStatement statement = con.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ProductMaster> addToCart(){
		ArrayList<ProductMaster> pms = new ArrayList<>();
		try (Connection con = DBConnectionDao.getConnection();
			PreparedStatement pst = con.prepareStatement(GET_BY_ID_LN_QRY);){
			ResultSet rs = pst.executeQuery();
			ProductMaster pm=null;
			while(rs.next()) {
				pm=  new ProductMaster();
				pm.setId(rs.getInt(1));
				pm.setProductName(rs.getString(2));
				pm.setCost(rs.getString(3));
				pm.setProductDescription(rs.getString(4));
				pms.add(pm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pms;
		
	}
}
