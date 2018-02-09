package org.code.main;

import org.bo.ClassCreator;
import org.junit.Test;

public class VOCodeMain {
	static String path = "D:/git/java/blog/src/main/java/";
	static String packageName = "org/blog/vo";
	ClassCreator classCreator = new ClassCreator();
	
	@Test
	public void vos() {
		classCreator.createClass("blog", "pub_permission", path, packageName);
		classCreator.createClass("blog", "pub_user", path, packageName);
		classCreator.createClass("blog", "pub_group", path, packageName);
		classCreator.createClass("blog", "pub_menu", path, packageName);
		classCreator.createClass("blog", "pub_user_group", path, packageName);
		classCreator.createClass("blog", "pub_config", path, packageName);
	}
	
	@Test
	public void pub_permission() {
		classCreator.createClass("blog", "pub_permission", path, packageName);
	}

	@Test
	public void pub_user() {
		classCreator.createClass("blog", "pub_user", path, packageName);
	}

	@Test
	public void pub_group() {
		classCreator.createClass("blog", "pub_group", path, packageName);
	}

	@Test
	public void pub_menu() {
		classCreator.createClass("blog", "pub_menu", path, packageName);
	}

	@Test
	public void pub_user_group() {
		classCreator.createClass("blog", "pub_user_group", path, packageName);
	}

	@Test
	public void pub_config() {
		classCreator.createClass("blog", "pub_config", path, packageName);
	}
}
