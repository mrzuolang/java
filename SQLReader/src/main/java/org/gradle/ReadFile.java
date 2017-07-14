package org.gradle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ReadFile implements Runnable {

	private File path;
	static int len = 100 * 1024 * 1024;

	public ReadFile(File path) {
		super();
		this.path = path;

	}

	public void run() {
		FileReader read = null;
		try {
			read = new FileReader(path);
			BufferedReader reader = new BufferedReader(read, len);
			StringBuffer sqls = new StringBuffer(len);
			String line = null;
			while ((line = reader.readLine()) != null) {
				sqls.append(line);
				System.out.println(line);
			}
			reader.close();
			Connection conn = JDBCFactory.getConn();
			Statement stat = conn.createStatement();
			System.out.println(sqls.length());
			stat.executeUpdate(sqls.toString());
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		Config.load();
		File[] files = new File(Config.path).listFiles();
		Queue<File> list = new LinkedBlockingQueue<File>(files.length);
		for (File file : files) {
			list.offer(file);
		}
		while (list.peek() != null) {
			ReadFile read = new ReadFile(list.poll());
			ExecutorService pool = Executors.newFixedThreadPool(Config.th_num);
			pool.submit(read);
		}

	}

}
