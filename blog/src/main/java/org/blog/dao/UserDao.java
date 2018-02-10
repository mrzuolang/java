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
	
	@Insert("INSERT INTO pub_user "
			+ "(`user_id`, `user_name`, `password`, `bill_code`, `nick_name`, `mail`, `phone`, `birthday`, `sex`, `pic_head`, `ts`, `time_stamp`, `tmp_int1`, `tmp_int2`, `tmp_int3`, `tmp_int4`, `tmp_var1`, `tmp_var2`, `tmp_var3`, `tmp_var4`) "
			+ "VALUES ('1', '1', '1', '1', '1', '1', '1', ' ', ' 1', '1', '1', '2018-02-12', '1', '1', '1', '1', '1', '1', '1', '1')")
	public int insert(@Param("user") UserVO user);
} 