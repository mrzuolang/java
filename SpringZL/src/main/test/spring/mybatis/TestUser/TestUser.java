package spring.mybatis.TestUser;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pub.dao.UserMapper;
import com.pub.vo.UserVO;

public class TestUser {
	@Test
	public void testInsertUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		UserMapper dao = context.getBean(UserMapper.class);
		UserVO vo = new UserVO();
		vo.setUser_id("1");
		vo.setUser_name("zuolang");
		vo.setBill_code("10000");
		dao.insert(vo);
	}
}
