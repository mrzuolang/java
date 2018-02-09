package spring.dao;

import org.blog.dao.UserDao;
import org.blog.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserDao {

	@Autowired
	private UserDao dao;
	
	
	
	@Test
	public void test() throws Exception {
		UserVO vo = new UserVO();
		vo.setUser_id(1);
		vo.setBill_code("001");
		vo.setUser_name("zuo lang");
		vo.setPhone("13261589000");
		vo.setMail("553050300@qq.com");
		//dao.insert(vo);
		dao.deleteByPk(vo.getUser_id());

	}
	
	
}
