package org.blog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
	@Delete("delete from pub_user where user_id=#{pk}")
	public int deleteByPk(@Param("pk") int pk);
}