package org.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserVO getUserById(@Param("pk") int pk) {
		return null;
	}

	public int update(@Param("user") UserVO user) {
		return 0;
	}

	public int insert(@Param("user") UserVO user) {
		return 0;
	}

	public int deleteByPk(@Param("pk") int pk) {
		return 0;
	}
	public String getUser_name() {
		return jdbcTemplate.queryForObject("select user_name from pub_user t where t.user_id=1", String.class);
	}
}