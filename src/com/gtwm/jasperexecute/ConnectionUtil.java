package com.gtwm.jasperexecute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Deprecated
public class ConnectionUtil {
	
//	String url = "jdbc:mysql://47.104.82.207:3306/blk";
//	String user = "blk_net";
//	String password = "blk@net@2017";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/blk";
	private static String user = "root";
	private static String password = "5542065a";
	
	public static Connection conn() {
		Connection connection = null;
        try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
