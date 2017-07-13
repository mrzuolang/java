package org.gradle;

import java.sql.Connection;
import java.sql.DriverManager;

public  class JDBCFactory {
	public static Connection getConn(){
		Config.load();
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			if(Config.username!=null){
				System.out.println(Config.url+"\\n"+Config.username+"\\n"+ Config.password);
				conn  = DriverManager.getConnection(Config.url, Config.username, Config.password);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
