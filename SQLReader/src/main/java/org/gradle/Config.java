package org.gradle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static String url = "";
	public static String username = "";
	public static String password = "";
	public static String path = "";
	public static int th_num;

	public static void load() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("db.properties"));
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			path = p.getProperty("path");
			th_num = Integer.parseInt(p.getProperty("thread"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
