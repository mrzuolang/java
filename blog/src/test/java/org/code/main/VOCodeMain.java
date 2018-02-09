package org.code.main;

import org.code.bo.VOClassCreator;
import org.junit.Test;

public class VOCodeMain {
	static String path = "D:/git/java/blog/src/main/java/";
	static String packageName = "org/blog/vo";
	VOClassCreator classCreator = new VOClassCreator();
	
	@Test
	public void vos() {
		classCreator.createVOClass("blog", "pub_permission", path, packageName);
		classCreator.createVOClass("blog", "pub_user", path, packageName);
		classCreator.createVOClass("blog", "pub_group", path, packageName);
		classCreator.createVOClass("blog", "pub_menu", path, packageName);
		classCreator.createVOClass("blog", "pub_user_group", path, packageName);
		classCreator.createVOClass("blog", "pub_config", path, packageName);
	}
	
	@Test
	public void pub_permission() {
		classCreator.createVOClass("blog", "pub_permission", path, packageName);
	}

	@Test
	public void pub_user() {
		classCreator.createVOClass("blog", "pub_user", path, packageName);
	}

	@Test
	public void pub_group() {
		classCreator.createVOClass("blog", "pub_group", path, packageName);
	}

	@Test
	public void pub_menu() {
		classCreator.createVOClass("blog", "pub_menu", path, packageName);
	}

	@Test
	public void pub_user_group() {
		classCreator.createVOClass("blog", "pub_user_group", path, packageName);
	}

	@Test
	public void pub_config() {
		classCreator.createVOClass("blog", "pub_config", path, packageName);
	}
}
