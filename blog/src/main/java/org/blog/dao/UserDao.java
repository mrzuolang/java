package org.blog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.blog.vo.UserVO;


@Mapper
public interface UserDao {
	@Delete("delete from pub_user where user_id=#{pk}")
	public int deleteByPk(@Param("pk") int pk);
	
	@Insert("insert into pub_user (user_id, user_name, password,bill_code, nick_name, mail,phone) "
			+ "values (#{user.user_id}, #{user.user_name},#{user.password},#{user.bill_code},#{user.nick_name},#{user.mail},#{user.phone})")
	public int insert(@Param("user") UserVO user);
	
} 