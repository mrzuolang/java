package com.zl.dao.pub;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zl.vo.pub.UserVO;

import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<UserVO>{
	
	public int insert(UserVO vo);
	
	public UserVO findByPK(@Param("user_id")String user_id);
	
	public UserVO find(@Param("bill_code")String bill_code,@Param("mail")String mail,@Param("phone")String phone);
	
    @Delete("delete from pub_user where user_id = #{id}")  
    public int deleteById(String id); 
}