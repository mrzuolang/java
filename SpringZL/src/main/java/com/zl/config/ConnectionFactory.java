package com.zl.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConection(){
		try {
			Class.forName(Config.MySQL_DIVER_CLASS_NAME);
			return  DriverManager.getConnection(Config.DB_URL,Config.DB_USERNAME,Config.DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
