package spring.test;
import org.blog.dao.UserDao;
import org.blog.start.BlogApplication;
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
		String name = dao.getUser_name();
		System.out.println(name);
	}
}
