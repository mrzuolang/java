package spring.base;

import java.util.Date;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import com.zl.dao.pub.UserMapper;
import com.zl.vo.pub.UserVO;

public class UserAssignServiceTest extends BaseJunit4Test {

	@Resource // 自动注入,默认按名称
	private UserMapper userDao;

	@Test // 标明是测试方法
	@Transactional // 标明此方法需使用事务
	@Rollback(false) // 标明使用完此方法后事务不回滚,true时为回滚
	public void insert() {
		UserVO vo = new UserVO();
		vo.setBill_code("888");
		vo.setBirthday(new Date());
		vo.setMail("mrzuolang@163.com");
		vo.setPhone("13000000001");
		vo.setPassword("1");
		userDao.insert(vo);
		
		
	}

}