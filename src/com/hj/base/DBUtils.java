package com.hj.base;

import java.sql.Connection;
import java.sql.SQLException;

import com.hj.datasource.DatasourceUtils;

public class DBUtils {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DatasourceUtils.getDataSource().getConnection();
	}
	
	public static Connection getConnection(String username, String password) throws SQLException {
		return DatasourceUtils.getDataSource().getConnection(username, password);
	}
	
	public static void close(AutoCloseable...closeables) {
		for (AutoCloseable closeable : closeables) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeable = null;
			}
		}
	}
}
