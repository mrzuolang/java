package org.zuolang.demo;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnFactory {

	public static Connection getConection(){
		try {
			Class.forName(Config.MYSQL_DIVER_CLASS_NAME);
			return  DriverManager.getConnection(Config.DB_URL,Config.DB_USERNAME,Config.DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
