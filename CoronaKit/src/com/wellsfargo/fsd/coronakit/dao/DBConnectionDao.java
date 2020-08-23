package com.wellsfargo.fsd.coronakit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionDao {
	
	private static DataSource datasource;
	
	public static Connection getConnection() throws SQLException{
		if(datasource==null) {
			try {
			InitialContext context = new InitialContext();
			datasource = (DataSource)context.lookup("java:/comp/env/jdbc/MyDB");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return datasource.getConnection();
		
	}
	
}