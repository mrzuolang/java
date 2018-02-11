package spring.test;

import org.blog.dao.UserDao;
import org.blog.start.BlogApplication;
import org.blog.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 注入测试
 * 
 * @author lang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
@EnableAutoConfiguration
public class SpringServiceTest {
	@Autowired
	private UserDao dao;

	@Test
	public void insert() {
		UserVO vo = new UserVO();
		vo.setUser_id(1);
		vo.setUser_name("zuolang");
		vo.setBill_code("001");
		vo.setNick_name("admin");
		vo.setMail("553050320@qq.com");
		vo.setPhone("13261589515");
		vo.setPassword("123456");
		dao.insert(vo);
	}

	@Test
	public void deleteByPk() {
		dao.deleteByPk(1);
	}

	@Test
	public void findByPk() {
		UserVO vo = dao.findByPk(1);
		System.out.println(vo.toString());
	}
	@Test
	public void update() {
		try {
		UserVO vo = dao.findByPk(1);
		System.out.println(vo.toString());
		vo.setUser_id(0);
		vo.setUser_name("zuo");
		int i = dao.updateByBillcode(vo);
		System.out.println(i==1?"更新成功":"更新失败");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
