package test.redis;

import org.job.bo.RedisBO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRedis {
	@Test
	public void testRedis() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		RedisBO bo = context.getBean(RedisBO.class);
		bo.setValue("hello", "world");
		System.out.println(bo.getValue("hello"));
		Assert.assertEquals("world", bo.getValue("hello"));
	}
}
