package org.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.blog.vo.UserVO;
@Mapper
public interface UserDao {

    UserVO getUserById(@Param("id") int id);

    int updateUser(@Param("user") UserVO user);

    int insertUser(@Param("user") UserVO user);

    int deleteUserById(@Param("id") int id);
}