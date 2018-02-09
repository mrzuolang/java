package org.code.tool;

import org.junit.Assert;
import org.junit.Test;

public class TestTableUtil {
	@Test
	public void testVoClassName() {
		Assert.assertEquals(TableUtil.getVOClassNameFromTableName("pub_user"), "UserVO");
		Assert.assertEquals(TableUtil.getVOClassNameFromTableName("pub_user_group"), "User_GroupVO");
		Assert.assertEquals(TableUtil.getVOClassNameFromTableName("pub_user_b"), "UserBVO");
	}
	@Test
	public void testMapperClassName() {
		Assert.assertEquals(TableUtil.getMapperClassNameFromTableName("pub_user"), "UserDao");
		Assert.assertEquals(TableUtil.getMapperClassNameFromTableName("pub_user_group"), "User_GroupDao");
		Assert.assertEquals(TableUtil.getMapperClassNameFromTableName("pub_user_b"), "UserBDao");
	}
}
