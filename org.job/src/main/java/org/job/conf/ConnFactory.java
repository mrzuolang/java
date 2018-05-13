package org.job.conf;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnFactory {

	public static Connection getConection(){
		try {
			Class.forName(DBConfig.MYSQL_DIVER_CLASS_NAME);
			return  DriverManager.getConnection(DBConfig.DB_URL,DBConfig.DB_USERNAME,DBConfig.DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection conn) {
		try {
			if(conn!=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
