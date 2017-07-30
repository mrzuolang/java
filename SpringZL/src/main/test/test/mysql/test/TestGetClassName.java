package test.mysql.test;

import org.junit.Assert;
import org.junit.Test;

import test.mysql.bo.MakeClassBo;

public class TestGetClassName {
	MakeClassBo bo = new MakeClassBo();
	@Test
	public void test() {
		Assert.assertEquals(bo.getClassName("user"), "UserVO");
	}
	@Test
	public void test_() {
		Assert.assertEquals(bo.getClassName("wp_users"), "UsersVO");
	}
	@Test
	public void test_b() {
		Assert.assertEquals(bo.getClassName("wp_users_b"), "UsersBVO");
	}
	@Test
	public void testb() {
		Assert.assertEquals(bo.getClassName("wp_users_param_b"), "Users_paramBVO");
	}
	@Test
	public void test1() {
		Assert.assertEquals(bo.getClassName("wp_users_param"), "Users_paramVO");
	}
	
	@Test
	public void test_upcase() {
		System.out.println((char)('c'-32));
	}
}
