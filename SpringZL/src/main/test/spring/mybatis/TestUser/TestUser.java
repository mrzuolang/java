package spring.mybatis.TestUser;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.dao.pub.UserMapper;
import com.zl.vo.pub.UserVO;

public class TestUser {
	@Test
	public void testInsertUser() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		UserMapper dao = context.getBean(UserMapper.class);
		System.out.println(dao);
		UserVO vo = new UserVO();
		vo.setUser_id("1");
		vo.setUser_name("zuolang");
		vo.setBill_code("10000");
		System.out.println(vo.toJson());
		dao.insert(vo);
		System.out.println(vo.toJson());
		
	}
}
