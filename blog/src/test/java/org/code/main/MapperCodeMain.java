package org.code.main;

import org.code.bo.DaoClassCreator;
import org.junit.Test;

public class MapperCodeMain {
	static String path = "M:/worksplace/org.job/src/main/java/";
	static String packageName = "org/job/dao";
	static String voPackageName="org/job/entity";
	static String DB_NAME="blog";
	DaoClassCreator classCreator = new DaoClassCreator();
	
	
	@Test
	public void vospk() {
		classCreator.createMapperClass(DB_NAME, "jobs", path, packageName,voPackageName);
		classCreator.createMapperClass(DB_NAME, "sys_config", path, packageName,voPackageName);
		classCreator.createMapperClass(DB_NAME, "pk10_2018", path, packageName,voPackageName);
		
	}
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
