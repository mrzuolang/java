package org.gradle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReadFile implements Runnable {
	public static Queue<String> sqlqueuen = new LinkedBlockingQueue<String>(100000);
	public static boolean over = false;// 文件读取完成标记

	public void read() {
		Config.load();
		String path = Config.path;
		if (path == null || path.length() < 1)
			return;
		File files = new File(path);
		for (File file : files.listFiles()) {
			if (!file.isFile() || !file.getName().endsWith(".sql")) {
				BufferedReader buff = null;
				try {
					buff = new BufferedReader(new FileReader(file));
					String insertSQL = null;
					String sql=null;
					while ((sql = buff.readLine()) != null) {
						if (sql.startsWith("insert")) {
							insertSQL = sql;
						} else if (sql.startsWith("values")) {
							System.out.println(insertSQL + sql);
							while (sqlqueuen.offer(insertSQL + sql)) {
								Thread.sleep(100);
							}
						} else {
							System.out.println("no====================");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (buff != null) {
						try {
							buff.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		over = true;// 文件读取完成
	}

	public void run() {
		String sql = null;
		Connection conn = JDBCFactory.getConn();
		try {
			while (!over) {
				if ((sql = sqlqueuen.poll()) != null) {
					Statement stat = conn.createStatement();
					System.out.println(sql);
					stat.execute(sql.substring(0, sql.length() - 1));
					stat.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Config.load();
		final ReadFile read = new ReadFile();

		Thread t = new Thread() {
			public void run() {
				read.read();
			}
		};
		t.start();
		System.out.println(Config.th_num);
		for (int i = 0; i < Config.th_num; i++) {
			Thread th = new Thread(read);
			th.start();
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
