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
	public void test1() {
		UserVO vo = new UserVO();
		vo.setUser_id(1);
		vo.setBill_code("001");
		vo.setUser_name("zuo lang");
		vo.setPhone("13261589000");
		vo.setMail("553050300@qq.com");
		System.out.println(vo.toString());
		dao.deleteByPk(1);
	}
}
