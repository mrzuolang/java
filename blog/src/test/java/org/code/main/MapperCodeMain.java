package org.code.main;

import org.code.bo.DaoClassCreator;
import org.junit.Test;

public class MapperCodeMain {
	static String path = "D:/git/java/blog/src/main/java/";
	static String packageName = "org/blog/dao";
	static String voPackageName="org/blog/vo";
	static String DB_NAME="blog";
	DaoClassCreator classCreator = new DaoClassCreator();
	
	@Test
	public void vos() {
		classCreator.createMapperClass(DB_NAME, "timer_task", path, packageName,voPackageName);
		classCreator.createMapperClass(DB_NAME, "timer_taskhistory", path, packageName,voPackageName);
		
	}
	
	@Test
	public void timer_task() {
		classCreator.createMapperClass(DB_NAME, "timer_task", path, packageName,voPackageName);
	}

	@Test
	public void timer_taskhistory() {
		classCreator.createMapperClass(DB_NAME, "timer_taskhistory", path, packageName,voPackageName);
	}
}
