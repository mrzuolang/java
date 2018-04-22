package org.code.main;

import org.code.bo.VOClassCreator;
import org.junit.Test;

public class VOCodeMain {
	static String path = "D:/gitub/java/blog/src/main/java/";
	static String packageName = "org/blog/vo";
	static String DB_NAME="pk10";
	VOClassCreator classCreator = new VOClassCreator();
	
	@Test
	public void vos() {
		classCreator.createVOClass(DB_NAME, "pub_permission", path, packageName);
		classCreator.createVOClass(DB_NAME, "pub_user", path, packageName);
		classCreator.createVOClass(DB_NAME, "pub_group", path, packageName);
		classCreator.createVOClass(DB_NAME, "pub_menu", path, packageName);
		classCreator.createVOClass(DB_NAME, "pub_user_group", path, packageName);
		classCreator.createVOClass(DB_NAME, "pub_config", path, packageName);
		classCreator.createVOClass(DB_NAME, "timer_taskhistory", path, packageName);
		classCreator.createVOClass(DB_NAME, "timer_task", path, packageName);
	}
	
	@Test
	public void pub_permission() {
		classCreator.createVOClass(DB_NAME, "pub_permission", path, packageName);
	}

	@Test
	public void pub_user() {
		classCreator.createVOClass(DB_NAME, "pub_user", path, packageName);
	}

	@Test
	public void pub_group() {
		classCreator.createVOClass(DB_NAME, "pub_group", path, packageName);
	}

	@Test
	public void pub_menu() {
		classCreator.createVOClass(DB_NAME, "pub_menu", path, packageName);
	}

	@Test
	public void pub_user_group() {
		classCreator.createVOClass(DB_NAME, "pub_user_group", path, packageName);
	}

	@Test
	public void pub_config() {
		classCreator.createVOClass(DB_NAME, "pub_config", path, packageName);
	}
	@Test
	public void task_timer() {
		classCreator.createVOClass(DB_NAME, "timer_task", path, packageName);
	}
	@Test
	public void task_history() {
		classCreator.createVOClass(DB_NAME, "timer_taskhistory", path, packageName);
	}
	@Test
	public void pk10() {
		classCreator.createVOClass(DB_NAME, "pk10_2018", path, packageName);
	}
}
