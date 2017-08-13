package com.pub.dao;

import com.pub.vo.UserVO;

import tk.mybatis.mapper.common.Mapper;
public interface UserMapper extends Mapper<UserVO>{
	
	public int insert(UserVO vo);
	
	public UserVO findByPK(String user_id);
}